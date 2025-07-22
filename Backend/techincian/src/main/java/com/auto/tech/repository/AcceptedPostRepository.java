package com.auto.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auto.tech.model.TechAcceptedPost;

@Repository
public interface AcceptedPostRepository extends JpaRepository<TechAcceptedPost, Long> {

    // ✅ All posts accepted by this technician
    @Query("SELECT t.postId FROM TechAcceptedPost t WHERE TRIM(LOWER(t.email)) = TRIM(LOWER(:email))")
    List<Long> findAllAcceptedPostIdsByEmail(@Param("email") String email);

    // ✅ All accepted posts (used to filter out accepted ones globally)
    @Query("SELECT t.postId FROM TechAcceptedPost t")
    List<Long> findAllAcceptedPostIds();

    // ✅ Check if a post is accepted by this technician (for display purposes)
    boolean existsByPostIdAndEmailIgnoreCase(Long postId, String email);

    // ✅ NEW: Check if a post is accepted by anyone (used in atomic check)
    boolean existsByPostId(Long postId);
}