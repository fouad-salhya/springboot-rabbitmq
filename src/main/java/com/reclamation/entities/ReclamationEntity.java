package com.reclamation.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamations")
public class ReclamationEntity implements Serializable {

	private static final long serialVersionUID = 4994876090215826979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reclamation_id")
	private String reclmationId;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_reclamation", nullable = false)
	private TypeReclamation typeReclamation;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "reclamation_status", nullable = false)
	private ReclamationStatus status;

	
	
	public String getReclmationId() {
		return reclmationId;
	}

	public void setReclmationId(String reclmationId) {
		this.reclmationId = reclmationId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
