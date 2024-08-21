package com.reclamation.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.reclamation.security.RabbitMQConfig;

@Service
public class UserReceiver {
	

    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Message received from " + RabbitMQConfig.USER_QUEUE + ": " + message);
    }

}
