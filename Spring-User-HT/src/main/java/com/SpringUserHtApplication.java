package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient

public class SpringUserHtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUserHtApplication.class, args);
		System.out.println("I am User Service");
	}

//	@Bean						// object creation taken care by us but maintain by container. 
//	@LoadBalanced
//	public RestTemplate	restTemplate() {
//		RestTemplate res = new RestTemplate();
//		return res;
//	}
}
