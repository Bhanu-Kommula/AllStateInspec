package com.auto.tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.tech.model.Technician;
import com.auto.tech.model.TechnicianAuditLog;

public interface TechnicianAuditLogRepository extends JpaRepository<TechnicianAuditLog, Long> {
	
    Optional<Technician> findByEmailIgnoreCase(String email);

}