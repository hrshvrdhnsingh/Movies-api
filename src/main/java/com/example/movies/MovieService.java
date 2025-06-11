package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// MovieService class acts as an intermediary between the controller (which handles HTTP requests)
// and the repository (which interacts with MongoDB)


// Dependency Injection - to manage dependencies automatically instead of manually creating objects.
@Service
public class MovieService {
    @Autowired // Spring injects MovieRepository automatically. SO now MovieService depends upon MovieRepository without creatung an object
    private MovieRepository movieRepository; // Reference of the actual repository

    public List<Movie> allMovies() {
        return movieRepository.findAll(); // The findAll is described in the mongoRepository class
    }

    public Optional<Movie> getMovie(String imdbId) { // TO let java know that the function could either return Movie or NULL.
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
