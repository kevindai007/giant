package com.kevindai.giant

/**
 * @Author daiwenkai
 * @Date 20/01/2020 10:58
 * */
public class BDTransGroovy {
    def parse(List<org.apache.http.NameValuePair> pairs, String appId, String appKey, Map<String, String[]> paramValueMap) {
        long l = System.currentTimeMillis();
        pairs.add(new org.apache.http.message.BasicNameValuePair("salt", String.valueOf(l)));
        def q = paramValueMap.get("q")[0];
        pairs.add(new org.apache.http.message.BasicNameValuePair("sign", cn.hutool.crypto.SecureUtil.md5((appId + q + l + appKey))));
        return pairs;
    }
}
