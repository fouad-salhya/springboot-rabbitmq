package com.reclamation.dtos;

import com.reclamation.entities.ReclamationStatus;
import com.reclamation.entities.TypeReclamation;

public class ReclamationDto {

	private String reclamationId;
	private TypeReclamation typeReclamation;
	private String description;
	private ReclamationStatus status;
	private String numero;

	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getReclamationId() {
		return reclamationId;
	}
	public void setReclamationId(String reclamationId) {
		this.reclamationId = reclamationId;
	}
	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}
	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReclamationStatus getStatus() {
		return status;
	}
	public void setStatus(ReclamationStatus status) {
		this.status = status;
	}
	
	



}
