package com.infosupport.cdi.topmovies;

import com.infosupport.model.MovieEntity;

import java.util.List;

@TopEarning
public class TopEarningMovies implements TopMovies {
    @Override
    public List<MovieEntity> listTopMovies() {
        return List.of(new MovieEntity("The Hobbit"), new MovieEntity("The Hobbit 2"));
    }
}
