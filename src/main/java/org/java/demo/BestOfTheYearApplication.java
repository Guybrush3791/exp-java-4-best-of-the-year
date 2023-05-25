package org.java.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestOfTheYearApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BestOfTheYearApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Hello, World!");
	}
}
