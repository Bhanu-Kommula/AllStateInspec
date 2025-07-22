package com.auto.postings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auto.postings.dto.DealerDTO;
import com.auto.postings.dto.LoginDealerDto;

@FeignClient(name = "dealer")
public interface DealerClient {
	
	@PostMapping("/login")
    DealerDTO getDealer(@RequestBody LoginDealerDto dealerDto);


}
