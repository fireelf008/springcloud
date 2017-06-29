//package com.wsf.controller;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
///**
// * Created by YSD on 2017/2/14.
// */
//@Service
//public class AMQPConsumer2 {
//
////    @RabbitListener(queues = "test")
////    @RabbitHandler
////    public void process(String msg) {
////        System.out.println("Receiver2 : " + msg);
////    }
//
//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//    @Bean
//    public Queue helloQueue() {
//        return new Queue("test", false);
//    }
//
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    @Bean
//    Binding bindingFanout() {
//        return BindingBuilder.bind(helloQueue()).to(fanoutExchange());
//    }
//
//    @Bean("process2")
//    public SimpleMessageListenerContainer process() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setQueues(helloQueue());
//        container.setExposeListenerChannel(true);
//        container.setConcurrentConsumers(10);
//        container.setMaxConcurrentConsumers(10);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
//        container.setMessageListener(new ChannelAwareMessageListener() {
//
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                byte[] body = message.getBody();
//                System.out.println("Listener onMessage2 : " + new String(body));
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
//            }
//        });
//        return container;
//    }
//}
