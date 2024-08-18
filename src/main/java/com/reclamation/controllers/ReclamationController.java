package com.reclamation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reclamation.requests.ReclamationRequest;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

	@GetMapping("/list")
	public String getReclamations() {
	
		return "hy";
	}
	
	@PostMapping("/create")
	public void addReclamation(@RequestBody ReclamationRequest reclamationRequest ) {
		
		
		
	}
}
