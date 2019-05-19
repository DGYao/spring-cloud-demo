package com.yao.client.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class AHystrix implements AFeign {
    @Override
    public String hello(@RequestParam("msg") String msg) {
        return "[fail send to A,msg:"+msg+"]";
    }
}
