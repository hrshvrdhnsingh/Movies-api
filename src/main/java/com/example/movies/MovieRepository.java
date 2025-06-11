package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Allows Spring to handle dependency injection and apply CRUD operations in the MONGO database
public interface MovieRepository extends MongoRepository<Movie, ObjectId> { // Works on Movie entity with ObjectId as primary key
    // The default searching via ObjectId is already given by the Spring. This is a custom query method
    Optional<Movie> findMovieByImdbId(String imdb);
}

// Extending MongoRepository gives us the in-built MongoDB CRUD operations like findById etc.
// Spring creates the implementation based on method name.