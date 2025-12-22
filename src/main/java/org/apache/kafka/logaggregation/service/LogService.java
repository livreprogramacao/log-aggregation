package org.apache.kafka.logaggregation.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "logs";

    public LogService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void logMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}