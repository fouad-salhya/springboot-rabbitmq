package com.reclamation.rabbitmq;


import java.util.concurrent.atomic.AtomicReference;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserReceiver {
	
    private final AtomicReference<String> userIdReference = new AtomicReference<>();	
	
    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void receiveUserId(String userId) {
        System.out.println("j ai recoit le userId " + RabbitMQConfig.USER_QUEUE + ": " + userId  );
        userIdReference.set(userId);
    }
    
    public String getUserId() {
        return userIdReference.get();
    }

	

}
