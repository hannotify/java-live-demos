package com.infosupport.cdi.topmovies;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

@Singleton
public class TopMoviesBean {
    private TopMovies topMovies;

    public TopMoviesBean() {
    }

    //@Inject @TopEarning
    public void setTopMovies(TopMovies topMovies) {
        this.topMovies = topMovies;
    }

    public void printTopMovies() {
        System.out.println("Top Movies: ");
        System.out.println(topMovies.listTopMovies());
    }
}
