package com.wsf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YSD on 2017/1/24.
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add")
    public String add(Integer a, Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        System.out.println(r);
        return "计算结果为：a + b = " + r;
    }

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addFallback")
    public String hello() {
        return "hello world!";
    }

    /**
     * 熔断器，通过spring cloud hystrix
     * @return
     */
    public String addFallback() {
        return "error";
    }
}
