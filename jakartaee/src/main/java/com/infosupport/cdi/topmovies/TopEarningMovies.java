package com.infosupport.cdi.topmovies;

import com.infosupport.model.Movie;

import java.util.List;

//@TopEarning
public class TopEarningMovies implements TopMovies {
    @Override
    public List<Movie> listTopMovies() {
        return List.of(new Movie("The Hobbit"), new Movie("The Hobbit 2"));
    }
}
