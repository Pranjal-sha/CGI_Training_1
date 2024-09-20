package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.FeignService;

@RestController
@RequestMapping("feign")
public class FeignController {
	@Autowired
	FeignService feignService;
	
	@GetMapping(value = "findProduct/{pid}")
	public String findAccountBalance(@PathVariable("pid") int pid) {
		return feignService.findProduct(pid);	// 100 line code 
	}


}
