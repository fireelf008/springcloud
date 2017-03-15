package com.wsf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by YSD on 2017/3/14.
 */
@Controller
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello() {
        logger.info("------hello----");
        return this.restTemplate.getForObject("http://zuul-server/sleuth-zipkin/sayHello", String.class);
    }

    @RequestMapping(value = "sayHello")
    @ResponseBody
    public String sayHello() {
        logger.info("------say hello----");
        return "Hello World";
    }
}
