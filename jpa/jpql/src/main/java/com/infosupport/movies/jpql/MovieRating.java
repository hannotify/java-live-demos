package com.infosupport.movies.jpql;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MovieRating {
    @Column(name = "rating")
    private double rating;

    public MovieRating() {}

    public MovieRating(double rating) {
        this.rating = rating;
    }
}
