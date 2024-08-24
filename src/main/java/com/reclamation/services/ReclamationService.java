package com.reclamation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reclamation.dtos.ReclamationDto;
import com.reclamation.dtos.UserDetails;
import com.reclamation.entities.ReclamationEntity;
import com.reclamation.entities.ReclamationStatus;
import com.reclamation.rabbitmq.ReclamationProducer;
import com.reclamation.rabbitmq.UserReceiver;
import com.reclamation.repositories.ReclamationRepository;
import com.reclamation.shared.Utils;

@Service
public class ReclamationService {

	@Autowired
	Utils utils;
	
	@Autowired
	ReclamationRepository reclmationRepository;
	
	@Autowired
	ReclamationProducer reclamationProducer;
	
	@Autowired
	UserReceiver userReceiver;
		
	
	public ReclamationDto create(ReclamationDto reclamationDto) throws InterruptedException, ExecutionException {
		
		ModelMapper modelMapper = new ModelMapper();
		
        UserDetails userDetails = userReceiver.getUserDetails();
		
		ReclamationEntity reclamationEntity = modelMapper.map(reclamationDto, ReclamationEntity.class);
		
		reclamationEntity.setReclamationId(utils.generateStringId(32));
		
		reclamationEntity.setStatus(ReclamationStatus.PENDING);	
		
		String userId = userDetails.getUserId();
		
        reclamationEntity.setUserId(userId);
        
        reclamationEntity.setNumero(utils.generateRandomNumero());
        
		ReclamationEntity reclamation = reclmationRepository.save(reclamationEntity);
		
		ReclamationDto newDto = modelMapper.map(reclamation, ReclamationDto.class);
		
		reclamationProducer.sendToReclamationQueue(newDto.getReclamationId());
		
		return newDto;
		
	}
	
	public List<ReclamationDto> getReclamations(int page , int limit) {
		
        if(page > 0) page = page - 1;
		
        Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ReclamationEntity> reclamationPage = reclmationRepository.findAll(pageableRequest);
		
		List<ReclamationEntity> reclamations = reclamationPage.getContent();
		
		List<ReclamationDto> reclamationsDto = new ArrayList<>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for(ReclamationEntity reclmation:reclamations ) {
			
			ReclamationDto reclamationDto = modelMapper.map(reclmation, ReclamationDto.class);
			
			reclamationsDto.add(reclamationDto);
		}
		
		return reclamationsDto;
		
	}
	
	public void removeReclamation(String userId) {
		
		ReclamationEntity reclamation = reclmationRepository.findByReclamationId(userId);
		
		 reclmationRepository.delete(reclamation);

	}
	
	
	
}
