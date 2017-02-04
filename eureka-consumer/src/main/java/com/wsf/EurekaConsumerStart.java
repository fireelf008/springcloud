package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EurekaConsumerStart {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerStart.class, args);
    }
}