package com.paymentService.ananda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AnandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnandaApplication.class, args);
	}

}
