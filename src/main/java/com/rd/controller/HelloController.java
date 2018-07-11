package com.rd.controller;

import com.rd.springboot.PeoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private PeoProperties peoProperties;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String say(){
        return peoProperties.getSex();
    }
}
