package com.wsf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    private static int i = 0;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addFallback", threadPoolProperties = {}, commandProperties = {@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")})
    public String add() {
        System.out.println(i++);
        if (5 <= i && i <= 15) {
            int i = 1/0;
        }
        return null;
//        return restTemplate.getForEntity("http://zuul-server/eureka-producer/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 熔断器，通过spring cloud hystrix
     * @return
     */
    public String addFallback() {
        return "error";
    }
}
