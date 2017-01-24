package com.wsf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wsf on 2017/1/16.
 */
@Controller
@EnableDiscoveryClient
@RequestMapping("/tc")
public class TestController {

//    @Value("${dev.test}")
//    private String devTest;

    @Value("${uat.test}")
    private String uatTest;

//    @RequestMapping(value = "/dev-test")
//    @ResponseBody
//    public String getDevTest()
//    {
//        return devTest;
//    }

    @RequestMapping(value = "/uat-test")
    @ResponseBody
    public String getUatTest()
    {
        return uatTest;
    }
}
