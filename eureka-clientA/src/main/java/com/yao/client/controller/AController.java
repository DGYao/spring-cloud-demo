package com.yao.client.controller;

import com.yao.client.constants.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private Global global;

    @RequestMapping("/helloA")
    public String hello(String msg) {
        return "[Hello,I'm "+name+",port is "+port+",receive msg is:"+msg+",env:"+global.getEnv()+"]";
    }
}
