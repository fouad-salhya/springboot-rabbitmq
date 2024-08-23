package com.reclamation.responses;

import com.reclamation.entities.ReclamationStatus;
import com.reclamation.entities.TypeReclamation;

public class ReclamationResponse {

	private String reclamationId;
	
	private TypeReclamation typeReclamation;
	
	private String description;
	
	private ReclamationStatus status;
	
	private String userId;

	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
