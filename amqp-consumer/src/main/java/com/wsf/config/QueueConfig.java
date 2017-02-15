package com.wsf.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YSD on 2017/2/14.
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello", false);
    }

    @Bean
    public Queue testQueue() {
        return new Queue("test", false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(helloQueue()).to(directExchange()).with("bindingDirect");
    }

    @Bean
    Binding bindingTopic() {
        return BindingBuilder.bind(testQueue()).to(topicExchange()).with("bindingTopic");
    }

    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(helloQueue()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout1() {
        return BindingBuilder.bind(testQueue()).to(fanoutExchange());
    }
}
