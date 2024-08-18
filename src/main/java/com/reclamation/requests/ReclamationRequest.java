package com.reclamation.requests;

import com.reclamation.entities.TypeReclamation;

public class ReclamationRequest {

	private TypeReclamation typeReclamation;
	private String description;
	
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
	

}
