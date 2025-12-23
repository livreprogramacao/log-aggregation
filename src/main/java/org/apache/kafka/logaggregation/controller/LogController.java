package org.apache.kafka.logaggregation.controller;

import org.apache.kafka.logaggregation.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/log")
    public void receiveLog(@RequestBody String message) {
        logger.debug("This is a debug message.");

        logService.logMessage(message);
    }
}