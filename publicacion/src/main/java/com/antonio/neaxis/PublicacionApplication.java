package com.antonio.neaxis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PublicacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicacionApplication.class, args);
	}

}
