package com.yao.client.controller;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.yao.client.constants.Global;
import com.yao.client.feign.CFeign;
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
    @Autowired
    private CFeign cFeign;

    @RequestMapping("/helloA")
    public String hello(String msg) {
        String hello = cFeign.hello(msg);
        return "[Hello,I'm "+name+",port is "+port+",receive msg is:"+msg+",get msg from C is "+hello+",env:"+global.getEnv()+"]";
    }

    @RequestMapping("/helloAFromC")
    public String helloAFromC(String msg){
        String hello = null;
        try {
            hello = cFeign.hello(msg);
        } catch (HystrixRuntimeException e) {//服务链接不上
            System.out.println("服务C链接不上:"+e.getMessage());
        } catch (HystrixBadRequestException e){//被调用服务的系统异常和业务异常
            System.out.println("服务C抛出业务/系统异常:"+e.getCause());
        }
        return "Hello,I'm " + name + ",port is " + port+",get msg from C is "+hello;
    }
}
