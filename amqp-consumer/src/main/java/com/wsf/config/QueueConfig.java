package com.wsf.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YSD on 2017/2/14.
 */
@Configuration
public class QueueConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public Queue helloQueue() {
        return new Queue("hello2", false);
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

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true); //必须要设置

        ExecutorService service = Executors.newFixedThreadPool(500);
        connectionFactory.setExecutor(service);

        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
}
