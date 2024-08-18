package com.reclamation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclamation.entities.ReclamationEntity;

@Repository
public interface ReclamationRepository extends JpaRepository<ReclamationEntity, Long> {

}
