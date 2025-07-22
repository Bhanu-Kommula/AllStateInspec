package com.auto.dealer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealer.model.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
	
	Optional<Dealer> findByEmail(String email);
	

}
