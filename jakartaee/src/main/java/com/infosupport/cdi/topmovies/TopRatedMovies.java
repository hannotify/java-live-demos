package com.infosupport.cdi.topmovies;

import com.infosupport.model.Movie;

import java.util.List;

//@TopRated
public class TopRatedMovies implements TopMovies {
    @Override
    public List<Movie> listTopMovies() {
        return List.of(new Movie("Memento"), new Movie("Shawshank Redemption"));
    }
}
