package com.yao.client.feign;

import com.yao.client.constant.FeignInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = FeignInfo.serviceNameA,fallback = AHystrix.class)
public interface AFeign {
    @RequestMapping(FeignInfo.Amethod1)
    String hello(@RequestParam("msg") String msg);
}
