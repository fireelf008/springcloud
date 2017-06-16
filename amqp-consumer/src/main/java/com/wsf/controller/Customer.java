//package com.wsf.controller;
//
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * Created by wangshaofu on 2017/6/15.
// */
//public class Customer {
//
//    public final static String QUEUE_NAME = "myQueue";
//    public final static String EXCHANGE_NAME = "myExchange";
//    public final static String EXCHANGE_TYPE = "fanout";
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        // 创建连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//
//        //设置RabbitMQ地址
//        factory.setHost("localhost");
//        factory.setUsername("root");
//        factory.setPassword("root");
//        factory.setPort(5672);
//
//        //创建一个新的连接
//        Connection connection = factory.newConnection();
//
//        //创建一个通道
//        final Channel channel = connection.createChannel();
//        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//
//        //声明要关注的队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        //bind
//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
//
//        System.out.println("Customer Waiting Received messages");
//
//        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
//        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
//        Consumer consumer = new DefaultConsumer(channel) {
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                String message = new String(body, "UTF-8");
//                System.out.println("Customer Received '" + message + "'");
//                channel.basicAck(channel.getChannelNumber(), false);
//            }
//        };
//        //自动回复队列应答 -- RabbitMQ中的消息确认机制
//        channel.basicConsume(QUEUE_NAME, false, consumer);
//    }
//}
