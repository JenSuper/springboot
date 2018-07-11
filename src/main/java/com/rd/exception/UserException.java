package com.rd.exception;

import com.rd.enums.UserEnum;

public class UserException extends  RuntimeException{

    private String code;

    public UserException(UserEnum userEnum) {
        super(userEnum.getMsg());
        this.code = userEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
