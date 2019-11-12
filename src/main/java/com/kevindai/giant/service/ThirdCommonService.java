package com.kevindai.giant.service;

import com.kevindai.giant.component.CommonHttpClient;
import com.kevindai.giant.constants.ParamConstants;
import com.kevindai.giant.enums.ErrorCode;
import com.kevindai.giant.mapper.GiantRecordInfoMapper;
import com.kevindai.giant.model.GiantRecordInfo;
import com.kevindai.giant.pojo.GiantRequestInfo;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.pojo.InterfaceInfo;
import com.kevindai.giant.utils.HttpUtils;
import com.kevindai.giant.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 16:36
 **/
@Slf4j
public abstract class ThirdCommonService {
    @Autowired
    private CommonHttpClient httpClient;
    @Autowired
    private GiantRecordInfoMapper giantRecordInfoMapper;

    protected abstract GiantResponseInfo validataParams(GiantRequestInfo requestInfo);

    protected abstract HttpUriRequest buildRequest(GiantRequestInfo requestInfo, InterfaceInfo interfaceInfo);

    protected abstract GiantResponseInfo parserResult(String result);

    public GiantResponseInfo run(GiantRequestInfo requestInfo, InterfaceInfo interfaceInfo) {
        //校验参数
        GiantResponseInfo responseInfo = validataParams(requestInfo);
        if (responseInfo != null) {
            return responseInfo;
        }


        try {
            //发送请求
            HttpUriRequest httpUriRequest = buildRequest(requestInfo, interfaceInfo);
            Future<HttpResponse> responseFuture = httpClient.getAsyncClient().execute(httpUriRequest, null);
            HttpResponse httpResponse = responseFuture.get(Integer.parseInt(interfaceInfo.getTimeout()), TimeUnit.SECONDS);
            String result = gainFromResponse(httpResponse);

            //解析结果
            responseInfo = parserResult(result);
        } catch (Exception e) {
            log.error("http error,{}", e.toString());
            return GiantResponseInfo.failure(ErrorCode.PARAM_NULL_ERROR);
        }
        return responseInfo;
    }

    private String gainFromResponse(HttpResponse response) throws IOException {
        String html = "";
        Header contentEncoding = response.getFirstHeader("Content-Encoding");
        if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
            html = HttpUtils.unzipToString(response.getEntity(), "UTF-8");
        } else {
            Charset charset = null;
            try {
                ContentType contentType = ContentType.get(response.getEntity());
                if (contentType != null) {
                    charset = contentType.getCharset();
                }
            } catch (Exception e) {
                charset = Charset.forName("UTF-8");
            }
            html = HttpUtils.toString(response.getEntity(), charset);
        }
        return html;
    }

    public void saveResult(GiantRequestInfo requestInfo, InterfaceInfo interfaceInfo, GiantResponseInfo responseInfo) {
        GiantRecordInfo giantRecordInfo = new GiantRecordInfo();
        giantRecordInfo.setPartnerCode(requestInfo.getPartnerCode());
        giantRecordInfo.setInterfaceId(interfaceInfo.getInterfaceId());
        giantRecordInfo.setIdNumber(requestInfo.getExtParams().get(ParamConstants.ID_NO));
        giantRecordInfo.setMobile(requestInfo.getExtParams().get(ParamConstants.MOBILE));
        giantRecordInfo.setName(requestInfo.getExtParams().get(ParamConstants.REAL_NAME));
        giantRecordInfo.setExtendValue(JacksonUtils.obj2Str(requestInfo.getExtParams()));
        giantRecordInfo.setSourceName(interfaceInfo.getServiceType());
        giantRecordInfo.setReasonCode(String.valueOf(responseInfo.getReasonCode()));
        giantRecordInfo.setResult(JacksonUtils.obj2Str(responseInfo));
        giantRecordInfo.setOriginResult(JacksonUtils.obj2Str(responseInfo.getOriginObj()));
        giantRecordInfoMapper.insert(giantRecordInfo);
    }

    public static void main(String[] args) {
        System.out.println(JacksonUtils.obj2Str("sdfadfwee2"));
    }
}
