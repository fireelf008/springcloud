package com.wsf.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fireelf on 2018/10/31.
 */
@FeignClient(name = "eureka-producer")
public interface ProducerRemote {

    @RequestMapping(value = "/producer/add")
    String remote_add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
