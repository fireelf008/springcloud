package com.wsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by wangshaofu on 2016/11/23.
 */
@SpringBootApplication
public class StreamConsumerStart {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerStart.class, args);
    }
}