package com.auto.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auto.tech.model.TechDeclinedPosts;

import feign.Param;

@Repository
public interface DeclinedPostsRepository extends JpaRepository<TechDeclinedPosts, Long> {
	

	 @Query("SELECT t.postId FROM TechDeclinedPosts t WHERE t.email = :email")
	    List<Long> findAllPostIdsByEmail(@Param("email") String email);
}
