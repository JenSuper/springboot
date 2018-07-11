package com.rd.enums;

public enum UserEnum {
    UNKNOW_ENUM("-1","成功"),
    SUCCESS_ENUM("200","未知错误"),
    ERROS_ENUM("500","失败"),
    ;

    private String code;
    private String msg;

    UserEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
