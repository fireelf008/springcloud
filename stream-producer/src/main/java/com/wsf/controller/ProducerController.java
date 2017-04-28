package com.wsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YSD on 2017/4/27.
 */
@Controller
@EnableBinding(IProducerTest.class)
public class ProducerController {

    @Autowired
    private IProducerTest producerTest;

    @RequestMapping(value = "output")
    @ResponseBody
    public String output() {
        this.producerTest.producerOutput().send(MessageBuilder.withPayload("Hello World").build());
        System.out.println("producer:ok");
        return "ok";
    }
}
