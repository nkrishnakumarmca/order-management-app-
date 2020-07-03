package com.kk.api.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private String exchangeName = "eventExchange";
    private String routingKey="order.*";

    public void sendMessage(String item) {
        amqpTemplate.convertAndSend(exchangeName, routingKey, item);
    }
}
