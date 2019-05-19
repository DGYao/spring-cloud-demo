package com.yao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSecondApplication.class, args);
    }

}
