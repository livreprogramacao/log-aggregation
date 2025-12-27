package org.apache.kafka.logaggregation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "logs";

    public LogService(KafkaTemplate<String, String> kafkaTemplate) {
        logger.info("This is a info message.");
        this.kafkaTemplate = kafkaTemplate;
        logger.info("This is a Apache Kafka template - TransactionIdPrefix '[{}]' property.", kafkaTemplate.getTransactionIdPrefix());
    }

    public void logMessage(String message) {
        logger.debug("This '[{}]' is a message sent.", message);
        kafkaTemplate.send(TOPIC, message);
    }
}