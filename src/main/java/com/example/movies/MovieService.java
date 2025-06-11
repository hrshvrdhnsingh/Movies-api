package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// MovieService class acts as an intermediary between the controller (which handles HTTP requests) and the repository (which
// interacts with MongoDB)

@Service // Business-logic component where complex operations are handled
public class MovieService {
    @Autowired // Spring injects MovieRepository automatically. SO now MovieService depends upon MovieRepository without creating an object
    private MovieRepository movieRepository; // Reference of the actual repository

    public List<Movie> allMovies() {
        return movieRepository.findAll(); // The findAll is described in the mongoRepository class
    }

    public Optional<Movie> getMovie(String imdbId) { // TO let java know that the function could either return Movie or NULL.
        return movieRepository.findMovieByImdbId(imdbId);
    }
}

// Dependency Injection - When the app starts, Spring looks for @Annotations, @Autowired and creates their classes and stores in
// it's container. It sees the Autowired field and sees that the MovieService needs a movieRespository. IT looks in it's container
// gets the object and assigns it to this field. So we never have to write new MovieRepository(). Spring hanldes object creaetino
// and injection.