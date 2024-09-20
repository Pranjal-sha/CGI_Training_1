package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GPAY-MIRCOSERVICE")
public interface GpayFeignService {

	@GetMapping(value = "gpay/findbalance/{emailid}")
	public String findBalace(@PathVariable("emailid") String emailid);
}