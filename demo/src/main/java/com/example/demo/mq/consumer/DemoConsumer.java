package com.example.demo.mq.consumer;

import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 消费者
 */
@Service
public class DemoConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(String message) {
        System.out.println("接收到消息: " + message);
    }
}
