package com.auto.tech.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.auto.tech.dto.PostingDTO;

@FeignClient(name = "postings")
public interface PostingClient {

    // ✅ Existing - Get all posts
    @GetMapping("/post")
    List<PostingDTO> getAllPostings();

    // ✅ New - Get a specific post by ID
    @GetMapping("/post/{id}")
    PostingDTO getPostById(@PathVariable("id") Long id);
}