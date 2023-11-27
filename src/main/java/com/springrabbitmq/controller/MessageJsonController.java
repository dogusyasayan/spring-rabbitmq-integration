package com.springrabbitmq.controller;


import com.springrabbitmq.domain.User;
import com.springrabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {

    // RabbitMQJsonProducer is injected using constructor injection
    private final RabbitMQJsonProducer jsonProducer;

    // HTTP POST endpoint to publish a JSON message to RabbitMQ
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        // Call the sendJsonMessage method of RabbitMQJsonProducer to send the JSON message to RabbitMQ
        jsonProducer.sendJsonMessage(user);

        // Return a success response indicating that the JSON message has been sent
        return ResponseEntity.ok("Json message sent to RabbitMQ!");
    }
}
