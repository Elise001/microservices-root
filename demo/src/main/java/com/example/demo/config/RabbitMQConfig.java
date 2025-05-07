package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "demo.queue";  // 队列名称
    public static final String EXCHANGE_NAME = "demo.exchange"; // 交换器名称
    public static final String ROUTING_KEY = "demo.key"; // 路由键

    // 绑定队列到交换器
    @Bean
    public Queue demoQueue() {
        return new Queue(QUEUE_NAME, true); // durable=true，持久化队列
    }

    // 定义交换器
    @Bean
    public DirectExchange demoExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false); // durable=true 持久化交换机, autoDelete=false 不自动删除
    }

    // 绑定队列到交换器
    @Bean
    public Binding demoBinding(Queue demoQueue, DirectExchange demoExchange) {
        return BindingBuilder.bind(demoQueue).to(demoExchange).with(ROUTING_KEY);
    }
}
