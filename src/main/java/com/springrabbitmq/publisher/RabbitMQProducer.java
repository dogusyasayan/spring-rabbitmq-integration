package com.springrabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    // The exchange name and routing key are injected from the configuration
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    // RabbitTemplate is injected using constructor injection
    private final RabbitTemplate rabbitTemplate;

    // Method to send a simple text message to RabbitMQ
    public void sendMessage(String message) {
        // Log the message before sending
        log.info(String.format("Message sent -> %s", message));

        // Use RabbitTemplate to convert and send the text message to the specified exchange and routing key
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}

