package com.example.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoviesApplication { // The entry point of this Spring project

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/") // Shows the code this method is a "GET" endpoint. And in the bracket we specify the ROUTES
	public String apiRoot() {
		return "Hello Randi";
	}
}
