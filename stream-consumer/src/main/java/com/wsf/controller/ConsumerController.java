package com.wsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YSD on 2017/4/27.
 */
@Controller
@EnableBinding(IConsumerTest.class)
public class ConsumerController {

    @Autowired
    private IConsumerTest consumerTest;

    @StreamListener("consumerInput")
    public void input(Object payload) {
        System.out.println("consumer:" + payload);
    }
}
