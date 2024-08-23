package com.reclamation.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reclamation.dtos.ReclamationDto;
import com.reclamation.requests.ReclamationRequest;
import com.reclamation.responses.ReclamationResponse;
import com.reclamation.services.ReclamationService;


@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

	@Autowired
	ReclamationService reclmationService;
	
	
	@GetMapping(
			path="/list",
			produces={MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<ReclamationResponse>>getAllReclamation(
			@RequestParam(value="page", defaultValue = "1") int page,@RequestParam(value="limit", defaultValue = "4")  int limit ) {
			
		 List<ReclamationDto> reclamationsDto = reclmationService.getReclamations(page, limit);
		 
		 ModelMapper modelMapper = new ModelMapper();
		 
		 List<ReclamationResponse> reclamationsResponse = new ArrayList<>();
		 
		 for(ReclamationDto reclamationDto:reclamationsDto) {
			 
			 ReclamationResponse reclResponse = modelMapper.map(reclamationDto, ReclamationResponse.class);
			 reclamationsResponse.add(reclResponse);
		 }
		
		return new ResponseEntity<List<ReclamationResponse>>(reclamationsResponse, HttpStatus.OK);
		
		
	}

	@PostMapping(
			path="/create",
		    consumes= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
		    produces= {MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<ReclamationResponse> addReclamation(@RequestBody ReclamationRequest reclamationRequest ) throws InterruptedException, ExecutionException {
		
		ModelMapper modelMapper = new ModelMapper();
		
		ReclamationDto reclmationDto = modelMapper.map(reclamationRequest, ReclamationDto.class);
		
		ReclamationDto newDto = reclmationService.create(reclmationDto);
		
		ReclamationResponse reclmationResponse = modelMapper.map(newDto, ReclamationResponse.class);
		
		return new ResponseEntity<ReclamationResponse>(reclmationResponse, HttpStatus.CREATED);
		
	}
}
