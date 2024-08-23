package com.reclamation.rabbitmq;

import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class ReclamationProducer {
	
	private final AmqpTemplate amqpTemplate;	
	private final Queue reclQueue;

    public ReclamationProducer(AmqpTemplate amqpTemplate,@Qualifier("reclamationQueue") Queue reclQueue) {
        this.amqpTemplate = amqpTemplate;
		this.reclQueue= reclQueue;
    }


    public void sendToReclamationQueue(String message) {
        amqpTemplate.convertAndSend(reclQueue.getName(), message);
        System.out.println("Message sent to reclamationQueue: " + message);
    }

}
