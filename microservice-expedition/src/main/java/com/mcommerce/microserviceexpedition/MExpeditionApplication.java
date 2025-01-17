package com.mcommerce.microserviceexpedition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mexpedition")
@EnableDiscoveryClient
public class MExpeditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MExpeditionApplication.class, args);
	}

}
