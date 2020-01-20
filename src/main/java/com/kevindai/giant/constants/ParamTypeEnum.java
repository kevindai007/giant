package com.kevindai.giant.constants;

/**
 * @Author daiwenkai
 * @Date 09/01/2020 16:46
 **/
public enum  ParamTypeEnum {
    VARIABLE("1"),
    CONSISTENT("2"),
    ENUMS("3");

    ParamTypeEnum(String i) {
        this.value = i;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
