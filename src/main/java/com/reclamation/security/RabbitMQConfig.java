package com.reclamation.security;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;


@Configuration
public class RabbitMQConfig {
	

    public static final String USER_QUEUE = "userQueue";
    public static final String RECLAMATION_QUEUE = "reclQueue";

    @Bean
    Queue userQueue() {
        return QueueBuilder.durable(USER_QUEUE)
                           .withArgument("x-queue-type", "quorum")
                           .build();
    }
    
    @Bean
    Queue reclamationQueue() {
        return QueueBuilder.durable(RECLAMATION_QUEUE)
                           .withArgument("x-queue-type", "quorum")
                           .build();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

}
