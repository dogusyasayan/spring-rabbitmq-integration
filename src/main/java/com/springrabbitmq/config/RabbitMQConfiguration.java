package com.springrabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfiguration {

    private final RabbitMQPropertiesConfig rabbitMQProperties;

    /**
     * Normal mesajları taşıyan RabbitMQ kuyruğunu oluşturur.
     * Creates a RabbitMQ queue for carrying regular messages.
     *
     * @return Oluşturulan kuyruk.
     */
    @Bean
    public Queue queue() {
        return QueueBuilder.durable(rabbitMQProperties.getQueue())
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", rabbitMQProperties.getDeadLetterRoutingKey())
                .build();
    }

    /**
     * JSON formatındaki mesajları taşıyan RabbitMQ kuyruğunu oluşturur.
     * Creates a RabbitMQ queue for carrying messages in JSON format.
     *
     * @return Oluşturulan kuyruk.
     */
    @Bean
    public Queue jsonQueue() {
        return QueueBuilder.durable(rabbitMQProperties.getJsonQueue())
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", rabbitMQProperties.getDeadLetterRoutingKey())
                .build();
    }

    /**
     * Mesaj alışverişini sağlayan RabbitMQ exchange'i oluşturur.
     * Creates a RabbitMQ exchange for message exchange.
     *
     * @return Oluşturulan exchange.
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(rabbitMQProperties.getExchange());
    }

    /**
     * Normal mesajları taşıyan kuyruk ile exchange arasında bağlantı kurar.
     * Establishes a binding between the queue carrying regular messages and the exchange.
     *
     * @param queue    Normal mesajları taşıyan kuyruk.
     * @param exchange Mesaj alışverişini sağlayan exchange.
     * @return Oluşturulan bağlantı.
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(rabbitMQProperties.getRoutingKey());
    }

    /**
     * JSON formatındaki mesajları taşıyan kuyruk ile exchange arasında bağlantı kurar.
     * Establishes a binding between the queue carrying JSON-formatted messages and the exchange.
     *
     * @param jsonQueue JSON formatındaki mesajları taşıyan kuyruk.
     * @param exchange  Mesaj alışverişini sağlayan exchange.
     * @return Oluşturulan bağlantı.
     */
    @Bean
    public Binding jsonBinding(Queue jsonQueue, TopicExchange exchange) {
        return BindingBuilder.bind(jsonQueue)
                .to(exchange)
                .with(rabbitMQProperties.getJsonRoutingKey());
    }

    /**
     * Mesajları JSON formatına dönüştüren dönüştürücüyü sağlar.
     * Provides the converter that transforms messages into JSON format.
     *
     * @return Oluşturulan dönüştürücü.
     */
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * RabbitMQ iletişimini sağlamak için kullanılan temel şablonu oluşturur.
     * Creates the fundamental template used for communication with RabbitMQ.
     *
     * @param connectionFactory RabbitMQ bağlantı fabrikası.
     * @return Oluşturulan şablon.
     */
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
