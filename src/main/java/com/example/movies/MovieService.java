package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// MovieService class acts as an intermediary between the controller (which handles HTTP requests) and the repository (which
// interacts with MongoDB)

@Service // Business-logic component where complex operations are handled
public class MovieService {
    @Autowired // Spring injects MovieRepository automatically. SO now MovieService depends upon MovieRepository without creating an object
    private MovieRepository movieRepository; // Reference of the actual repository
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll(); // The findAll is described in the mongoRepository class
    }

    public Optional<Movie> getMovie(String imdbId) { // TO let java know that the function could either return Movie or NULL.
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Optional<List<Review>> getReviews(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId)
                .map(movie -> reviewRepository.findAllById(
                        movie.getReviewIds() // returns List<ObjectId>
                                .stream()
                                .map(Review::getId)  // or just return list of IDs directly if stored that way
                                .collect(Collectors.toList())
                ));
    }
}

// Dependency Injection - When the app starts, Spring looks for @Annotations, @Autowired and creates their classes and stores in
// it's container. It sees the Autowired field and sees that the MovieService needs a movieRepository. IT looks in it's container
// gets the object and assigns it to this field. So we never have to write new MovieRepository(). Spring handles object creating
// and injection.