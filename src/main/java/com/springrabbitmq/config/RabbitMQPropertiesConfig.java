package com.springrabbitmq.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RabbitMQPropertiesConfig {

    // Queue name for carrying regular messages - Normal mesajları taşıyan kuyruk adı
    @Value("${rabbitmq.queue.name}")
    private String queue;

    // Queue name for carrying JSON format messages - JSON formatındaki mesajları taşıyan kuyruk adı
    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    // Exchange name for facilitating message exchange - Mesaj alışverişini sağlayan exchange adı
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    // Routing key between the queue carrying regular messages and the exchange - Normal mesajları taşıyan kuyruk ile exchange arasındaki routing key
    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    // Routing key between the queue carrying JSON format messages and the exchange - JSON formatındaki mesajları taşıyan kuyruk ile exchange arasındaki routing key
    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    // Routing key for messages to be directed to the dead letter queue -  Dead letter kuyruğa yönlendirilecek mesajlar için routing key
    @Value("${rabbitmq.dead-letter.routing.key}")
    private String deadLetterRoutingKey;
}
