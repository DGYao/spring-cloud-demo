package com.yao.client.controller;

import com.yao.client.constant.Global;
import com.yao.client.feign.AFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private Global global;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AFeign aFeign;

    @RequestMapping("/helloB")
    public String hello() {
        String msgFromA = restTemplate.getForObject("http://eureka-clientA/helloA", String.class,"BBB");
        return "Hello,I'm " + name + ",port is " + port+",get msg from A is "+msgFromA+",env:"+global.getEnv();
    }

    @RequestMapping("/helloB-Feign")
    public String helloFeign() {
        return "Hello,I'm " + name + ",port is " + port+",get msg from A is "+aFeign.hello("BBB-Feign");
    }
}
