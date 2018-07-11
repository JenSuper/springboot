package com.rd.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;


/**
 * AOP
 */
@Aspect
@Component
public class HttpAspect {

    private  final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public  * com.rd.controller.UserController.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public  void before(){


        logger.info("before");
    }

    @After("pointCut()")
    public  void after(){
        logger.info("after");
    }

    @AfterReturning(returning = "obj",pointcut = "pointCut()")
    public  void afterReturn(Object obj){
//        logger.info("response={}",obj.toString());
    }
}
