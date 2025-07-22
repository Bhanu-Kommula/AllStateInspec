package com.auto.tech.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto.tech.dto.GetTechAccpetedPostsByEmailDto;
import com.auto.tech.dto.LoginTechnicanDto;
import com.auto.tech.dto.PostingDTO;
import com.auto.tech.dto.TechAcceptedPostsDto;
import com.auto.tech.dto.TechDeclinedPostsDto;
import com.auto.tech.dto.TechInfoToGetPostsByLocationDto;
import com.auto.tech.dto.UpdateTechnicianDto;
import com.auto.tech.model.TechAcceptedPost;
import com.auto.tech.model.TechDeclinedPosts;
import com.auto.tech.model.Technician;
import com.auto.tech.service.TechnicianService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TechnicianController {
	
	private final TechnicianService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody Technician technician) {
		
		service.register(technician);
		
		return ResponseEntity.status(201).body(technician);
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login( @RequestBody LoginTechnicanDto dealer){
	
	
    return service.login(dealer.getEmail());
	
    
}
	@PostMapping("/technician-feed")
	public List<PostingDTO> getTechnicianFeed(@RequestBody TechInfoToGetPostsByLocationDto dto) {
	    return service.getFilteredFeed(dto);
	}
	
	
	
    @PostMapping("/technician-posts-by-techloc")
    public List<PostingDTO> getAllPostingsFromPostingsService(@RequestBody TechInfoToGetPostsByLocationDto dto) {
        return service.fetchAllPostings(dto);
    }
    
    
    
    @PostMapping("/save-accepted-posts")
    public ResponseEntity<?> techAcceptedPosts(@RequestBody TechAcceptedPostsDto dto) {
        try {
            TechAcceptedPost acceptedPosts = TechAcceptedPost.builder()
                    .email(dto.getEmail())
                    .postId(dto.getPostId())
                    .build();

            service.techAcceptedPosts(acceptedPosts);

            return ResponseEntity.ok("Accepted successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Something went wrong"));
        }
    }
    
    
    
    
    
    
    @PostMapping("/get-accepted-posts-by-email")
    public List<Long> getAcceptedPostsByEmail(@RequestBody GetTechAccpetedPostsByEmailDto dto){
    	return service.getAcceptedPostsByEmail(dto);
    }

    
    
    @PostMapping("/get-technician-by-email")
    public Optional<Technician> getTechnicianByEmail(@RequestBody GetTechAccpetedPostsByEmailDto email) {
        
        return service.getTechnicianByEmail(email);
    }
    
    
    
    

    @PostMapping("/declined-posts")
    public void declinedPosts(@RequestBody TechDeclinedPostsDto declinedPosts) {
    	
    	TechDeclinedPosts posts = TechDeclinedPosts.builder()
    			.email(declinedPosts.getEmail())
    			.postId(declinedPosts.getPostId())
    				.build();
    	
    	
    	service.declinedPosts(posts);
    	
    	
    }
    
    @GetMapping("/get-all-accepted-posts-full")
    public List<TechAcceptedPost> getAllAcceptedPostMappings() {
        return service.getAllAcceptedPostsWithTechnician();
    }
    
    
    
    
    
    @PostMapping("/update-technician-profile")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateTechnicianDto dto) {
        Technician updated = service.updateTechnicianProfile(dto);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/get-technician-profile")
    public ResponseEntity<?> getTechnicianProfile(@RequestParam String email) {
        Optional<Technician> technicianOpt = service.getTechnicianByEmail(email);

        if (technicianOpt.isPresent()) {
            return ResponseEntity.ok(technicianOpt.get());
        } else {
            return ResponseEntity.status(404).body("Technician not found");
        }
    }
    
}
