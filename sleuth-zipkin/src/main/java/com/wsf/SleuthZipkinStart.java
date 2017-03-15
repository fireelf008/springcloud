package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SleuthZipkinStart {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinStart.class, args);
    }
}