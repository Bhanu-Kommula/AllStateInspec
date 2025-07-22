package com.auto.dealer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.dealer.model.Dealer;
import com.auto.dealer.model.DealerAuditLog;

public interface DealerAuditLogRepository extends JpaRepository<DealerAuditLog, Long> {
    Optional<Dealer> findByEmail(String email);  // ✅ Add this method

}