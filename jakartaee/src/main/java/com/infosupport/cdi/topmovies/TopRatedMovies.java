package com.infosupport.cdi.topmovies;

import com.infosupport.model.Movie;
import com.infosupport.model.MovieEntity;

import java.util.List;

@TopRated
public class TopRatedMovies implements TopMovies {
    @Override
    public List<MovieEntity> listTopMovies() {
        return List.of(new MovieEntity("Memento"), new MovieEntity("Shawshank Redemption"));
    }
}
