package com.kevindai.giant.enums;

public enum ErrorCode {
    PARAM_NULL_ERROR("101", "参数不能为空"),
    PARAM_OVER_MAX_LEN("103", "参数超过最大长度"), // 个别参数有长度限制
    PARAM_NOT_VALID("104", "参数不合法"), // 个别参数有长度限制
    SUCCESS("200", "请求已完成"),
    UNSUPPORTED_SERVICE("405", "不支持的服务类型"), //; // 参数不能为空
    UNKNOWN_ERROR("500", "未知错误"); //; // 参数不能为空

    private String code;
    private String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ":" + message;
    }
    }
