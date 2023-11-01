package com.infosupport.movies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long movieId;
    private String name;

    public Movie(String name) {
        this.name = name;
    }
}
