package com.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.healthcare.model")
public class HealthcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);
	}

}
