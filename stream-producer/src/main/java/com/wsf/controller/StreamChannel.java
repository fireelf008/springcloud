package com.wsf.controller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamChannel {

    @Output
    MessageChannel createOrderOutput();

    @Output
    MessageChannel sendSmsOutput();
}