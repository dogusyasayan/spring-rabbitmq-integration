package com.springrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    // RabbitListener annotation is used to specify the queue(s) to listen for messages
    // errorHandler is set to "defaultRabbitListenerErrorHandler" to handle errors during message consumption

    // RabbitListener anotasyonu, mesajları dinlemek için hangi kuyrukları izleyeceğimizi belirtmek için kullanılır
    // errorHandler, mesaj tüketimi sırasında hataları yönetmek için "defaultRabbitListenerErrorHandler" olarak ayarlanır

    @RabbitListener(queues = {"${rabbitmq.queue.name}"}, errorHandler = "defaultRabbitListenerErrorHandler")
    public void consume(String message) {
        // Log the received message
        // Alınan mesajı logla
        log.info(String.format("Received message -> %s", message));
    }
}
