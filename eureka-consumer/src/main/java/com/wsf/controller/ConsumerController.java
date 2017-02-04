package com.wsf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by YSD on 2017/1/24.
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addFallback")
    public String add() {
        return restTemplate.getForEntity("http://zuul-server/ep/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 熔断器，通过spring cloud hystrix
     * @return
     */
    public String addFallback() {
        return "error";
    }
}
