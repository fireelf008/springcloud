package com.wsf.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by YSD on 2017/2/14.
 */
@Service
@RabbitListener(queues = "test")
public class AMQPConsumer2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver2 : " + msg);
    }
}
