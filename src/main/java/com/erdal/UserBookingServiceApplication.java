package com.erdal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserBookingServiceApplication.class, args);
	}

}
