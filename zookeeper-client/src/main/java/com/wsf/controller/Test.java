package com.wsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class Test {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public void discovery() {
        System.out.println(discoveryClient.getServices());
    }

    @RequestMapping("/test")
    public void test() {
        System.out.println("==============");
    }
}
