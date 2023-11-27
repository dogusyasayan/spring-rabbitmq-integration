package com.springrabbitmq.publisher;

import com.springrabbitmq.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQJsonProducer {

    // The exchange name and routing key are injected from the configuration
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    // RabbitTemplate is injected using constructor injection
    private final RabbitTemplate rabbitTemplate;

    // Method to send a JSON message to RabbitMQ
    public void sendJsonMessage(User user) {
        // Log the JSON message before sending
        log.info(String.format("Json message sent -> %s", user.toString()));

        // Use RabbitTemplate to convert and send the JSON message to the specified exchange and routing key
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
