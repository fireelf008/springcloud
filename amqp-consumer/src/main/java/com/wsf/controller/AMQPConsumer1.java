package com.wsf.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by YSD on 2017/2/14.
 */
@Service
public class AMQPConsumer1 {

//    @RabbitListener(queues = "hello2")
//    @RabbitHandler
//    public void process(String msg) {
//        System.out.println("Receiver1 : " + msg);
//    }
//
//    @RabbitListener(queues = "test")
//    @RabbitHandler
//    public void process2(String msg) {
//        System.out.println("Receiver2 : " + msg);
//    }

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public Queue testQueue() {
        return new Queue("test", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(testQueue()).to(fanoutExchange());
    }

    @Bean("process1")
    public SimpleMessageListenerContainer process() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(testQueue());
        container.setExposeListenerChannel(true);
        container.setConcurrentConsumers(10);
        container.setMaxConcurrentConsumers(10);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("Listener onMessage1 : " + new String(body));
                Thread.sleep(5000);
                //确认消息成功消费
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false);
                //确认消息消费失败，第三个参数true表示重试，false表示从队列中移除
                if ("111".equals(new String(body))) {
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                } else {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                }
//                channel.basicRecover(false);
            }
        });
        return container;
    }
}
