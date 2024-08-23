package com.reclamation.rabbitmq;

import org.springframework.stereotype.Component;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;


@Component
public class ReclamationProducer {
	
	private final AmqpTemplate amqpTemplate;	
	private final Queue reclQueue;

    public ReclamationProducer(AmqpTemplate amqpTemplate,@Qualifier("reclamationQueue") Queue reclQueue) {
        this.amqpTemplate = amqpTemplate;
		this.reclQueue= reclQueue;
    }


    public void sendToReclamationQueue(String reclamationId) {
        amqpTemplate.convertAndSend(reclQueue.getName(), reclamationId);
        System.out.println("reclamationId sent to nodejs reclamationQueue: " + reclamationId);
    }

}
