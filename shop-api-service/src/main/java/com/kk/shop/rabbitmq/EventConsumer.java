package com.kk.shop.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventConsumer {

    private final String queueName = "orderServiceQueue";

    @RabbitListener(queues=queueName)
    public void receive(String message) {
        System.out.println("Received message ::" + message);
        log.info("Received message '{}'", message);
    }
}
