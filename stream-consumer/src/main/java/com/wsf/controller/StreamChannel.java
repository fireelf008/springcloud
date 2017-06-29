package com.wsf.controller;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StreamChannel {

    @Input
    SubscribableChannel createOrderInput();

    @Input
    SubscribableChannel sendSmsInput();
}