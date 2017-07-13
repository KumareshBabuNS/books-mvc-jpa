package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
	  return args -> {
	    repo.save(new Book("0312152906", "Knitting with Dog Hair", "Kendall Crolius"));
	    repo.save(new Book("1594745250", "Crafting with Cat Hair", "Kaori Tsutaya"));
	  };
	}
	
}
