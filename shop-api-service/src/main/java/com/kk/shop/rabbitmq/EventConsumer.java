package com.kk.shop.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class EventConsumer {
    @RabbitListener(queues="orderServiceQueue")
    public void receive(String message) {
        System.out.println("Received message ::" + message);
        log.info("Received message '{}'", message);
    }
}
