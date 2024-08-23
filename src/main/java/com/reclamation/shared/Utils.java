package com.reclamation.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom(); 
	private final String ALPHANUMERIQUE = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	
	public String generateStringId(int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i = 0; i < length; i++) {
			
			returnValue.append(ALPHANUMERIQUE.charAt(RANDOM.nextInt(ALPHANUMERIQUE.length())));
		}
		return new String(returnValue);
	}
	
	 public String generateRandomNumero() {
	        Random random = new Random();
	        int randomNum = 100000 + random.nextInt(900000);  
	        return String.valueOf(randomNum);
	    }

}
