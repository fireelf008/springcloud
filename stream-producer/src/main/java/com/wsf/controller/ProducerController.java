package com.wsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YSD on 2017/4/27.
 */
@Controller
public class ProducerController {

    @Autowired
    StreamChannel streamChannel;

    @RequestMapping("output")
    @ResponseBody
    public String output(){

        // 字符串类型发送MQ
        System.out.println("字符串信息发送");
        streamChannel.createOrderOutput().send(MessageBuilder.withPayload("创建订单").build());
        streamChannel.sendSmsOutput().send(MessageBuilder.withPayload("发送短信").build());
        return "ok";
    }
}
