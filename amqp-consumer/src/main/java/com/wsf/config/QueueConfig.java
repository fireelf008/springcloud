package com.wsf.test;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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

//    @Bean
//    public Queue testQueue() {
//        return new Queue("test", false);
//    }

//    @Bean
//    DirectExchange directExchange() {
//        return new DirectExchange("directExchange");
//    }
//
//    @Bean
//    TopicExchange topicExchange() {
//        return new TopicExchange("topicExchange");
//    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

//    @Bean
//    Binding bindingDirect(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("bindingDirect");
//    }
//
//    @Bean
//    Binding bindingTopic(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("bindingTopic");
//    }

    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(helloQueue()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout1() {
        return BindingBuilder.bind(testQueue()).to(fanoutExchange());
    }
}
