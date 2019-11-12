package com.kevindai.giant.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 10:05
 **/
@Getter
@Setter
public class GiantRequestInfo {
    private String partnerCode;
    private String partnerKey;
    private String seqId;
    private String productCode;
    private Map<String,String> extParams = new HashMap<>();

}
