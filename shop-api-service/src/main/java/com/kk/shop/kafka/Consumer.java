package com.kk.shop.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    /*@KafkaListener(id = "simple-consumer", topics = "client")
    public void consumeMessage(String message) {
        System.out.println("Got message: " + message);
    }*/
}
