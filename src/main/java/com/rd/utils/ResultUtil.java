package com.rd.utils;

import com.rd.entity.ResultJson;

public class ResultUtil {

    /**
     * 上传成功
     * @return
     */

    public static ResultJson success(Object obj){
        ResultJson ret=new ResultJson();
        ret.setCode("200");
        ret.setMsg("成功");
        ret.setData(obj);
        return  ret;
    }

    /**
     * 上传失败
     * @return
     */
    public  static ResultJson erro(){
        return  null;
    }

    public  static ResultJson erro(String code,String msg){
        ResultJson ret=new ResultJson();
        ret.setCode(code);
        ret.setMsg(msg);
        return  ret;
    }
}
