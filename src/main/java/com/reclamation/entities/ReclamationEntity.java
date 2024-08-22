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

	@Column
	private String reclamationId;
/*
	@Column(name = "user_id", nullable = false)
	private String userId;
	*/

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TypeReclamation typeReclamation;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ReclamationStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
