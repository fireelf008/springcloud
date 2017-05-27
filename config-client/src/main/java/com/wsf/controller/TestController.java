package com.wsf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wsf on 2017/1/16.
 */
@RestController
@RefreshScope
@RequestMapping("/tc")
public class TestController {

    @Value("${my.test}")
    private String test;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String getUatTest()
    {
        return test;
    }
}
