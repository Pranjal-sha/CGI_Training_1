package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-MIRCOSERVICE")		// providing account micro service name part of eureka server 
public interface AccountFeignService {

	@GetMapping(value = "account/findbalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno);	// this method call end point 
}