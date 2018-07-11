package com.rd.handel;

import com.rd.entity.ResultJson;
import com.rd.exception.UserException;
import com.rd.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Handel {

    private  final static Logger logger= LoggerFactory.getLogger(Handel.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultJson handel(Exception e){
        if (e instanceof UserException){
            UserException userException= (UserException) e;
             return ResultUtil.erro(userException.getCode(),userException.getMessage());
        }else {
            logger.error("[系统异常] {}",e);
            return ResultUtil.erro("-1","未知错误");
        }
    }
}
