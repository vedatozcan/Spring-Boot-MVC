package com.TechCarrerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class TechCarrerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechCarrerApiApplication.class, args);
	}

}
