package com.example.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // Tells us it's the main class and automatically sets up the database, server and finds the other classes
@RestController // TO turn this class into REST API handler
public class MoviesApplication {

	public static void main(String[] args) { // The entry point of this Spring project
		SpringApplication.run(MoviesApplication.class, args); // Boots up the entire framework and the server as well
	}

	@GetMapping("/") // Shows the code this method is a "GET" endpoint. And in the bracket we specify the ROUTES
	public String apiRoot() {
		return "Hello Movies Application";
	}
}
// SO when the server starts, the MongoDB connection gets established and the REST API become available.

// HTTP Request → Controller → Service → Repository → MongoDB
// Controller handles HTTP requests
// Service takes care of the business logic of these two
// Repository focuses on the database operations