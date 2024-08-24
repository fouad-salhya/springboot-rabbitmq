package com.reclamation.rabbitmq;

import java.util.concurrent.atomic.AtomicReference;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reclamation.dtos.UserDetails;

@Component
public class UserReceiver {

	/*
	 * private final AtomicReference<String> userIdReference = new
	 * AtomicReference<>();
	 * 
	 * @RabbitListener(queues = RabbitMQConfig.USER_QUEUE) public void
	 * receiveUserId(String userId) { System.out.println("j ai recoit le userId " +
	 * RabbitMQConfig.USER_QUEUE + ": " + userId ); userIdReference.set(userId); }
	 * 
	 * public String getUserId() { return userIdReference.get(); }
	 * 
	 */

	private final AtomicReference<UserDetails> userDetailsReference = new AtomicReference<>();
	private final ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
	public void receiveUserDetails(String message) {
		try {
			UserDetails userDetails = objectMapper.readValue(message, UserDetails.class);
			System.out.println("Received user details: " + userDetails);
			userDetailsReference.set(userDetails);
		} catch (Exception e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
	}

	public UserDetails getUserDetails() {
		return userDetailsReference.get();
	}

}
