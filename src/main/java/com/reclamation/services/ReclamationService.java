package com.reclamation.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reclamation.dtos.ReclamationDto;
import com.reclamation.entities.ReclamationEntity;
import com.reclamation.entities.ReclamationStatus;
import com.reclamation.repositories.ReclamationRepository;
import com.reclamation.shared.Utils;

@Service
public class ReclamationService {

	@Autowired
	Utils utils;
	
	@Autowired
	ReclamationRepository reclmationRepository;
	
	
	
	
	public ReclamationDto create(ReclamationDto reclmationDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		
		ReclamationEntity reclamationEntity = modelMapper.map(reclmationDto, ReclamationEntity.class);
		
		reclamationEntity.setReclmationId(utils.generateStringId(32));
		
		reclamationEntity.setStatus(ReclamationStatus.PENDING);	
		
		ReclamationEntity reclamation = reclmationRepository.save(reclamationEntity);
		
		ReclamationDto newDto = modelMapper.map(reclamation, ReclamationDto.class);
		
		return newDto;
		
		
	}
}
