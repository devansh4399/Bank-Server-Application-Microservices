package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApiGatewayApplication.class, args);
	}

}
