package com.auto.postings.dto;

import java.util.Date;

import com.auto.postings.model.PostStatus;

import lombok.Data;

@Data
public class PostRequestDto {
    private String email;         // User’s email (for fetching name)
    private String content;       // Posting content
    private String location;      // Location
    private String offerAmount;
    private PostStatus status; // ✅ Add this line
    
    //This all will be updated whern technician accepts 
    private Long postId;
    private Date statusUpdatedAt;
private String technicianName;
private String technicianEmail;


 private Date expectedCompletionBy;



}
