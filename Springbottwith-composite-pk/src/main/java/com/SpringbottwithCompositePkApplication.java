package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
public class SpringbottwithCompositePkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbottwithCompositePkApplication.class, args);
		System.out.println("New topic Up");
	}

}
