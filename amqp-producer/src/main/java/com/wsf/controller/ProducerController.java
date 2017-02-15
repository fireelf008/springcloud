package com.wsf.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by YSD on 2017/2/15.
 */
@RestController
public class ProducerController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/direct")
    public void sendDirect() {
        String context = "hello direct " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("directExchange", "bindingDirect", context);
    }

    @RequestMapping(value = "/topic")
    public void sendTopic() {
        String context = "hello topic " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("topicExchange", "bindingTopic", context);
    }

    @RequestMapping(value = "/fanout")
    public void sendFanout() {
        String context = "hello fanout " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange", null, context);
    }
}
