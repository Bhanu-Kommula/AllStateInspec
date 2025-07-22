package com.auto.postings.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.postings.model.Posting;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long>{
    List<Posting> findByEmailOrderByIdDesc(String email); // latest first
    List<Posting> findAll();
	void deleteById(Long id);
	Optional<Posting> findById(Long id);
	
	

	
}
