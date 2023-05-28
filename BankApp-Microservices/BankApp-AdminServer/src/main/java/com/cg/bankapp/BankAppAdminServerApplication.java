package com.cg.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class BankAppAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppAdminServerApplication.class, args);
	}

}
