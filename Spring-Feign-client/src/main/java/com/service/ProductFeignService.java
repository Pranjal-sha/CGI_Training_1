package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SPRING-PRODUCT-MYSQL")  //provide the name of microservice	
public interface ProductFeignService {
	
	
	@GetMapping(value = "product/{pid}")
	public String getProductById(@PathVariable("pid") int pid);
	
	

}
