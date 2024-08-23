package com.reclamation.rabbitmq;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserReceiver {
	

    private CompletableFuture<String> userIdFuture = new CompletableFuture<>();
	
	
    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void receiveUserId(String userId) {
        System.out.println("Message received from " + RabbitMQConfig.USER_QUEUE + ": " + userId  );
        userIdFuture.complete(userId);
    }
    
    public String getUserId() throws InterruptedException, ExecutionException {
        return userIdFuture.get();  // Bloque jusqu'à ce que le userId soit disponible
    }

	

}
