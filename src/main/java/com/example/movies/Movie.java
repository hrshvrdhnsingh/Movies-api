package com.example.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // Lets it know that this class represents each document in the movie collection in database
@Data // ensures there are getter and setter for each of the private members
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId, title, releaseDate, trailerLink, poster;
    private List<String> genres, backdrops;
    @DocumentReference // TO tell the framework that is a collection of ids referring the Reviews class
    private List<Review> reviewIds;
}


