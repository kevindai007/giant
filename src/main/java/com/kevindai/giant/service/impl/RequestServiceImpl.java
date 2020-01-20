package com.kevindai.giant.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.FluentIterable;
import com.kevindai.giant.component.CommonHttpClient;
import com.kevindai.giant.constants.*;
import com.kevindai.giant.enums.ErrorCode;
import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.service.RequestService;
import com.kevindai.giant.utils.VelocityTransfer;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author daiwenkai
 * @Date 10/01/2020 16:47
 **/
@Slf4j
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private CommonHttpClient httpClient;

    private static GroovyShell groovyShell = new GroovyShell();
    private static Map<String, Script> groovyScriptCache = new ConcurrentHashMap<>();

    @Override
    public GiantResponseInfo request(ServiceConfigInfoWithBLOBs serviceConfigInfo, HttpServletRequest request) {


        Map<String, String[]> parameterMap = request.getParameterMap();

        HttpUriRequest httpUriRequest = buildRequestParam(parameterMap, serviceConfigInfo);

        Future<HttpResponse> future = httpClient.getAsyncClient().execute(httpUriRequest, null);
        try {
            HttpResponse httpResponse = future.get(Integer.parseInt(serviceConfigInfo.getTimeout()), TimeUnit.SECONDS);
            String responseContent = EntityUtils.toString(httpResponse.getEntity());


            //todo 经过groovy脚本渲染

            //拿到response之后把结果渲染到output_template中
            String result = transferResult(responseContent, serviceConfigInfo.getOutputTemplate());

            return GiantResponseInfo.success(JSON.parseObject(result));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("http request error,{}", e.toString());
        }

        return GiantResponseInfo.failure(ErrorCode.UNKNOWN_ERROR);
    }

    private String transferResult(String responseContent, String outputTemplate) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(responseContent)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", responseContent);
            try {
                sb.append(VelocityTransfer.transfer(jsonObject, outputTemplate));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private HttpUriRequest buildRequestParam(Map<String, String[]> parameterMap, ServiceConfigInfoWithBLOBs serviceConfigInfo) {
        HttpRequestBase httpRequest = null;
        //拼接url
        String url = serviceConfigInfo.getUrl();
        String inputConfig = serviceConfigInfo.getInputConfig();
        JSONArray array = JSONArray.parseArray(inputConfig);
        url = buildUrl(array, parameterMap, url);

        //构建body
        if (MethodTypeConstants.POST.equals(serviceConfigInfo.getMethodType())) {
            HttpPost post = new HttpPost(url);
            //form表单
            if (ContentTypeConstants.FORM.equals(serviceConfigInfo.getContentType())) {
                post.setEntity(buildFormBodyEntity(array, parameterMap, serviceConfigInfo.getRequestScript()));
            } else if (ContentTypeConstants.JSON.equals(serviceConfigInfo.getMethodType())) {
                //json格式
                post.setEntity(buildJSONBodyEntity(array, parameterMap));
            } else if (ContentTypeConstants.XML.equals(serviceConfigInfo.getMethodType())) {
                // todo
            }
            httpRequest = post;
        } else if (MethodTypeConstants.GET.equals(serviceConfigInfo.getMethodType())) {
            httpRequest = new HttpGet(url);
        }


        //构建header
        List<Header> headerList = builderHeader(array, parameterMap);
        httpRequest.setHeaders(FluentIterable.from(headerList).toArray(Header.class));
        return httpRequest;
    }

    /**
     * 构建 header
     *
     * @param array
     * @param parameterMap
     */
    private List<Header> builderHeader(JSONArray array, Map<String, String[]> parameterMap) {
        List<Header> headers = new ArrayList<>();
        Map<String, String> paramValueMap = buildParamValue(array, SendSpaceConstants.HEADER, parameterMap);
        for (Map.Entry<String, String> entry : paramValueMap.entrySet()) {
            headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
        }
        return headers;
    }


    private Map<String, String> buildParamValue(JSONArray array, String sendSpace, Map<String, String[]> parameterMap) {
        Map<String, String> paramValueMap = new HashMap<>();
        array.stream().filter(s -> sendSpace.equals(((JSONObject) s).getString("send_space")))
                .forEach(s -> {
                    JSONObject config = (JSONObject) s;
                    if (ParamTypeEnum.CONSISTENT.getValue().equals(config.getString("type"))) {
                        paramValueMap.put(config.getString("service_param"), config.getString("value"));
                    } else {
                        paramValueMap.put(config.getString("service_param"), parameterMap.get(config.getString("service_param"))[0]);
                    }
                });

        return paramValueMap;
    }

    /**
     * 把url中的变量替换为入参中的值或配置中的常量
     *
     * @param array
     * @param parameterMap
     * @param url
     * @return
     */
    private String buildUrl(JSONArray array, Map<String, String[]> parameterMap, String url) {
        Map<String, String> paramValueMap = buildParamValue(array, SendSpaceConstants.URL, parameterMap);
        for (Map.Entry<String, String> entry : paramValueMap.entrySet()) {
            url = StringUtils.replace(url, "${" + entry.getKey() + "}", entry.getValue());
        }
        return url;
    }


    /**
     * 把body中需要的参数构建成entity
     *
     * @param array
     * @param parameterMap
     * @return
     */
    private StringEntity buildFormBodyEntity(JSONArray array, Map<String, String[]> parameterMap, String requestScript) {
        Map<String, String> paramValueMap = buildParamValue(array, SendSpaceConstants.BODY, parameterMap);

        List<NameValuePair> pairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : paramValueMap.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        //通过groovy脚本构建一些特殊参数
        try {
            pairs.addAll(invoke(requestScript, GlobeConstants.GROOVY_SCRIPT_FUN_NAME, pairs, BDTransConstant.APPID, BDTransConstant.APPKEY, parameterMap));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("groovy {} script run error",requestScript);
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, Charsets.UTF_8);
        return entity;
    }

    private StringEntity buildJSONBodyEntity(JSONArray array, Map<String, String[]> parameterMap) {
        Map<String, String> paramValueMap = buildParamValue(array, SendSpaceConstants.BODY, parameterMap);
        String jsonstr = JSON.toJSONString(paramValueMap);

        StringEntity stringEntity = new StringEntity(jsonstr, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");

        return stringEntity;

    }

    private static <T> T invoke(String scriptText, String function, Object... objects) throws Exception {
        Script script;
        String cacheKey = DigestUtils.md5Hex(scriptText);

        if (groovyScriptCache.containsKey(cacheKey)) {
            script = groovyScriptCache.get(cacheKey);
        } else {
            script = groovyShell.parse(scriptText);
            groovyScriptCache.put(cacheKey, script);
        }
        return (T) InvokerHelper.invokeMethod(script, function, objects);
    }


    public static void main(String[] args) throws Exception {
        String script = "def parse(List<org.apache.http.NameValuePair> pairs, String appId, String appKey, Map<String, String[]> paramValueMap) {\n" +
                "        long l = System.currentTimeMillis();\n" +
                "        pairs.add(new org.apache.http.message.BasicNameValuePair(\"salt\", String.valueOf(l)));\n" +
                "        def q = paramValueMap.get(\"q\")[0];\n" +
                "        pairs.add(new org.apache.http.message.BasicNameValuePair(\"sign\", cn.hutool.crypto.SecureUtil.md5((appId + q + l + appKey))));\n" +
                "        return pairs;\n" +
                "    }";
        List<NameValuePair> pairs = new ArrayList<>();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("q",new String[]{"侧四"});
        Object invoke = RequestServiceImpl.invoke(script, GlobeConstants.GROOVY_SCRIPT_FUN_NAME, pairs, BDTransConstant.APPID, BDTransConstant.APPKEY,parameterMap);
        System.out.println(JSON.toJSONString(invoke));

    }
}
