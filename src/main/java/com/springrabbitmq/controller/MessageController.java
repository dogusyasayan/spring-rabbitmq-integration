package com.springrabbitmq.controller;

import com.springrabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    // RabbitMQProducer is injected using constructor injection
    private final RabbitMQProducer producer;

    // HTTP GET endpoint to publish a message to RabbitMQ
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        // Call the sendMessage method of RabbitMQProducer to send the message to RabbitMQ
        producer.sendMessage(message);

        // Return a success response indicating that the message has been sent
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }
}