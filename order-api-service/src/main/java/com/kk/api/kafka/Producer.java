package com.kk.api.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    private KafkaTemplate<String, String> simpleProducer;

    public Producer(KafkaTemplate<String, String> simpleProducer) {
        this.simpleProducer = simpleProducer;
    }

    public void send(String message) {
        simpleProducer.send("client", message);
    }
}
