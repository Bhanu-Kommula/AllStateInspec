package com.auto.postings.dto;

import lombok.Data;

@Data
public class EditPostRequestDto {
	
	
	private long id;
	private String content;
	private String location;
	private String offerAmount;

}
