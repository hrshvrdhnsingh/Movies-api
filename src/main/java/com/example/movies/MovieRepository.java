package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Allows Spring to handle dependency injection and apply CRUD operations in the MONGO database
public interface MovieRepository extends MongoRepository<Movie, ObjectId> { // extending allows use of mongo operations
    Optional<Movie> findMovieByImdbId(String imdb); // WE implement this to allow searching via imdbId and not the actual objectId.
}
