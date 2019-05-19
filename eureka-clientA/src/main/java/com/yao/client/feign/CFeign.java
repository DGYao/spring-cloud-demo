package com.yao.client.feign;

import com.yao.client.constants.FeignInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = FeignInfo.serviceNameC)
public interface CFeign {
    @RequestMapping(FeignInfo.Cmethod1)
    String hello(@RequestParam("msg") String msg);
}
