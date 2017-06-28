package com.wsf.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by YSD on 2017/2/15.
 */
@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ConnectionFactory connectionFactory;

    @RequestMapping(value = "/direct")
    public void sendDirect() {
        String context = "hello direct " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("directExchange", "bindingDirect", context);
    }

    @RequestMapping(value = "/topic")
    public void sendTopic() {
        String context = "hello topic " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "bindingTopic", context);
    }

    @RequestMapping(value = "/fanout")
    public void sendFanout() {
        String context = "cccccc " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", null, context);
    }

    @RequestMapping(value = "/send")
    public void send(){

        String content = "你好，世界！";
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        RabbitTemplate rt = new RabbitTemplate(connectionFactory);
        rt.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println(correlationData.getId());
                System.out.println(b);
                System.out.println(s);
            }
        });
        rt.convertAndSend("fanoutExchange", null, content, correlationId);
        System.out.println("消息id" + correlationId.getId() + "--->" + content);
    }
}
