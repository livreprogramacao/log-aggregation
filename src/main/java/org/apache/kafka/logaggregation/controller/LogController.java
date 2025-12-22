package org.apache.kafka.logaggregation.controller;

import org.apache.kafka.logaggregation.service.LogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/log")
    public void receiveLog(@RequestBody String message) {
        logService.logMessage(message);
    }
}