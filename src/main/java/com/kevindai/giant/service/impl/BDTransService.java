package com.kevindai.giant.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.kevindai.giant.enums.ErrorCode;
import com.kevindai.giant.pojo.InterfaceInfo;
import com.kevindai.giant.pojo.GiantRequestInfo;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.service.ThirdCommonService;
import com.kevindai.giant.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 17:36
 **/
@Slf4j
@Component("bDTransService")
public class BDTransService extends ThirdCommonService {
    public static final String APPID = "20191111000355873";
    public static final String APPKEY = "EW_ZTVftjscw4aWmKEih";

    @Override
    protected GiantResponseInfo validataParams(GiantRequestInfo requestInfo) {
        if (requestInfo == null || CollectionUtils.isEmpty(requestInfo.getExtParams())) {
            return GiantResponseInfo.failure(ErrorCode.PARAM_NULL_ERROR);
        }
        Map<String, String> extParams = requestInfo.getExtParams();
        if (!extParams.containsKey("q")) {
            log.info("q not exists");
            return GiantResponseInfo.failure(ErrorCode.PARAM_NULL_ERROR);
        } else if (extParams.get("q").length() > 1500) {
            log.info("the length of q is to long,{}", extParams.get("q"));
            return GiantResponseInfo.failure(ErrorCode.PARAM_OVER_MAX_LEN);
        }
        return null;
    }

    @Override
    protected HttpUriRequest buildRequest(GiantRequestInfo requestInfo, InterfaceInfo interfaceInfo) {
        HttpPost post = new HttpPost(interfaceInfo.getUrl());

        long l = System.currentTimeMillis();
        String q = requestInfo.getExtParams().get("q");
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("q", q));
        pairs.add(new BasicNameValuePair("from", "auto"));
        pairs.add(new BasicNameValuePair("to", "en"));
        pairs.add(new BasicNameValuePair("appid", APPID));
        pairs.add(new BasicNameValuePair("salt", String.valueOf(l)));
        pairs.add(new BasicNameValuePair("sign", SecureUtil.md5((APPID + q + l + APPKEY))));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, Charsets.UTF_8);
        post.setEntity(entity);
        return post;
    }

    @Override
    protected GiantResponseInfo parserResult(String result) {
        JsonNode jsonNode = JacksonUtils.str2JsonObj(result);
        JsonNode dst = jsonNode.get("trans_result").get(0).get("dst");
        GiantResponseInfo success = null;
        if (StringUtils.isEmpty(dst)) {
            success = GiantResponseInfo.success(dst, 1);
        } else {
            success = GiantResponseInfo.success(dst);
        }
        success.setOriginObj(result);
        return success;
    }
}
