package com.apirest.demowebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemowebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemowebfluxApplication.class, args);
		System.out.println("Demo WebFlux rodando ...");
	}

}
