package com.rd.entity;

/**
 * 返回指定格式
 */
public class ResultJson<T> {

    /** 返回码*/
    private String code;
    /**返回信息*/
    private String msg;
    /**返回结果*/
    private T data;

    public ResultJson() {
    }

    public ResultJson(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
