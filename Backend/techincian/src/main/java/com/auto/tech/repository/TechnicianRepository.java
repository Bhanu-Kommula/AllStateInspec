package com.auto.tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.tech.dto.TechInfoToGetPostsByLocationDto;
import com.auto.tech.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
	
	Optional<Technician> findByEmailIgnoreCase(String email);

	

}
