package com.springrabbitmq.consumer.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultRabbitListenerErrorHandler implements RabbitListenerErrorHandler {

    /**
     * RabbitMQ kuyruğundan mesaj dinleme sırasında bir hata oluştuğunda çağrılır.
     * This method is invoked when an error occurs while listening to a message from the RabbitMQ queue.
     *
     * @param amqpMessage Alınan RabbitMQ mesajı.
     * @param message     Spring Messaging API'sinden gelen mesaj.
     * @param exception   Oluşan hatayı temsil eden istisna.
     * @return            İşlem hatası durumunda fırlatılacak olan istisna veya başka bir işlem yapılacaksa null.
     */
    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) {
        log.error("Kuyruk dinleme sırasında bir hata oluştu. Mesaj: " + amqpMessage, exception);

        // Hatanın işlenmemiş bir hatayı temsil etmesi durumunda tekrar fırlatılır.
        // If the error represents an unhandled exception, it is rethrown.
        throw exception;
    }
}
