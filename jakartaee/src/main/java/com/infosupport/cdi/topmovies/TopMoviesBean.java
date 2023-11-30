package com.infosupport.cdi.topmovies;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

@Singleton
public class TopMoviesBean {
    @Inject @TopRated
    private TopMovies topMovies;

    public void printTopMovies() {
        System.out.println("Top Movies: ");
        System.out.println(topMovies.listTopMovies());
    }
}
