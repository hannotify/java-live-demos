package com.infosupport.movies.inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Year;

@Entity
public class Award {
    @Id
    @GeneratedValue
    private long id;
    private Year year;
    private String category;

    @ManyToOne
    private Movie movie;

    public Award() {}
    public Award(Year year, String category) {
        this.year = year;
        this.category = category;
    }

    public void setMovie(com.infosupport.movies.inheritance.Movie movie) {
        this.movie = movie;
    }
}
