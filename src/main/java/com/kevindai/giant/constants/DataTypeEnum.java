package com.kevindai.giant.constants;

/**
 * @Author daiwenkai
 * @Date 09/01/2020 16:46
 **/
public enum DataTypeEnum {
    STR("1"),
    INT("2"),
    FLOATT("3"),
    BOOL("4"),
    DATE("5");

    DataTypeEnum(String i) {
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
