package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class TurbineAmpqStart {

    public static void main(String[] args) {
        SpringApplication.run(TurbineAmpqStart.class, args);
    }
}