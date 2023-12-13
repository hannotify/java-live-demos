package com.infosupport.cdi.topmovies;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

@Singleton
public class TopMoviesBean {
    TopMovies topMovies;

    public TopMoviesBean() {}

    @Inject
    public TopMoviesBean(@TopRated TopMovies topMovies) {
        this.topMovies = topMovies;
    }

    public void printTopMovies() {
        System.out.println("Top Movies: ");
        System.out.println(topMovies.listTopMovies());
    }
}
