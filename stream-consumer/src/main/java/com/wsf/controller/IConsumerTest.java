package com.wsf.controller;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by YSD on 2017/4/27.
 */
public interface IConsumerTest {

    @Input
    SubscribableChannel consumerInput();

//    @Output
//    MessageChannel consumerOutput();
}