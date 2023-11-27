package com.springrabbitmq.consumer;

import com.springrabbitmq.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQjSONConsumer {
    // The RabbitListener annotation is used to specify which queue to listen for JSON messages
    // errorHandler is set to "defaultRabbitListenerErrorHandler" to handle errors during message consumption

    // RabbitListener anotasyonu, JSON mesajlarını dinlemek için hangi kuyruğu izleyeceğimizi belirtmek için kullanılır
    // errorHandler, mesaj tüketimi sırasında hataları yönetmek için "defaultRabbitListenerErrorHandler" olarak ayarlanır
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"},
            errorHandler = "defaultRabbitListenerErrorHandler")
    public void consumeJsonMessage(User user) {
        // Log the received JSON message
        // Alınan JSON mesajını logla
        log.info(String.format("Recieved JSON message -> %s", user.toString()));
    }
}
