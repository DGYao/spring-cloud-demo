package com.yao.client.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class CHystrix implements CFeign {
    @Override
    public String hello(@RequestParam("msg") String msg) {
        return "[feign-->fail send to C,msg:"+msg+"]";
    }
}
