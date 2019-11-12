package com.kevindai.giant.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kevindai.giant.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author daiwenkai
 * @Date 08/11/2019 17:52
 **/
@Getter
@Setter
public class GiantResponseInfo {
    /**
     * 三方业务是否正常返回
     */
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("reason_code")
    private int reasonCode;
    @JsonProperty("reason_desc")
    private String reasonDesc;
    /**
     * success=false，不返回该字段
     * 0代表业务成功，1代表业务失败
     */
    @JsonProperty("result")
    private int result;
    /**
     * success=false，不返回该字段
     * 三方返回的具体结果
     */
    @JsonProperty("dispaly")
    private Object dispaly;

    @JsonIgnore
    private Object originObj;


    public static GiantResponseInfo failure(ErrorCode errorCode) {
        GiantResponseInfo responseInfo = new GiantResponseInfo();
        responseInfo.setSuccess(false);
        responseInfo.setReasonCode(Integer.parseInt(errorCode.getCode()));
        responseInfo.setReasonDesc(errorCode.getMessage());
        return responseInfo;
    }

    public static GiantResponseInfo success(Object o, int result) {
        GiantResponseInfo responseInfo = new GiantResponseInfo();
        responseInfo.setSuccess(true);
        responseInfo.setReasonCode(Integer.parseInt(ErrorCode.SUCCESS.getCode()));
        responseInfo.setReasonDesc(ErrorCode.SUCCESS.getMessage());
        responseInfo.setResult(result);
        responseInfo.setDispaly(o);
        return responseInfo;
    }

    public static GiantResponseInfo success(Object o) {
        GiantResponseInfo responseInfo = new GiantResponseInfo();
        responseInfo.setSuccess(true);
        responseInfo.setReasonCode(Integer.parseInt(ErrorCode.SUCCESS.getCode()));
        responseInfo.setReasonDesc(ErrorCode.SUCCESS.getMessage());
        responseInfo.setResult(0);
        responseInfo.setDispaly(o);
        return responseInfo;
    }


}
