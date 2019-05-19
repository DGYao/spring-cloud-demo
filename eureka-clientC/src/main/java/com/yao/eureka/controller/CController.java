package com.yao.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/helloC")
    public String hello(String msg) {
        int i = 1 / 0;
        return "[Hello,I'm "+name+",port is "+port+",receive msg is:"+msg+"]";
    }
}
