package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerStart.class, args);
    }
}