package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerStart {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerStart.class, args);
    }
}