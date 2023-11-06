package com.infosupport.movies.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Embeddable
public class MovieRating {
    @Column(name = "rating")
    private double rating;

    public MovieRating() {}

    public MovieRating(double rating) {
        this.rating = rating;
    }
}
