package com.infosupport.movies.relationships;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class MovieRating {
    @Id
    private long id;
    private double rating;

    public MovieRating() {}

    public MovieRating(double rating) {
        this.rating = rating;
    }

    @OneToOne
    @JoinColumn(name = "movieId")
    @MapsId
    private Movie movie;

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
