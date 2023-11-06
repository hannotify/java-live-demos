package com.infosupport.movies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long movieId;
    private String name;

    @OneToOne(mappedBy = "movie")
    private MovieRating movieRating;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Award> awards = new HashSet<>();

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public void addAward(Award award) {
        awards.add(award);
        award.setMovie(this);
    }

    public void setRating(MovieRating rating) {
        rating.setMovie(this);
        movieRating = rating;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }
}
