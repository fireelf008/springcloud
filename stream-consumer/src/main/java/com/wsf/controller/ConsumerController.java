package com.wsf.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * Created by YSD on 2017/4/27.
 */
@Controller
public class ConsumerController {

    @StreamListener("createOrderInput")
    public void createOrderInput(Message<String> message) {
        System.out.println("消费者收到：" + message.getPayload());
    }

    @StreamListener("sendSmsInput")
    public void sendSmsInput(Message<String> message) {
        System.out.println("消费者收到：" + message.getPayload());
    }
}
