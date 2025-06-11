package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController // SHows that this is a REST API controller
@RequestMapping("/api/v1/movies") // All endpoints in this start from this base URL
public class MovieController {
    @Autowired
    private MovieService movieService; // Spring automatically injects the movieService

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() { // ResponseEntity is a wrapper for HTTP requests with status code
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) { // To extract imdbId from the URL
        return new ResponseEntity<Optional<Movie>>(movieService.getMovie(imdbId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{imdbId}")
    public ResponseEntity<?> getAllReviews(@PathVariable String imdbId) {
        Optional<List<Review>> reviews = movieService.getReviews(imdbId);

        if (reviews.isPresent()) {
            return new ResponseEntity<>(reviews.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie not found or no reviews available", HttpStatus.NOT_FOUND);
        }
    }
}
