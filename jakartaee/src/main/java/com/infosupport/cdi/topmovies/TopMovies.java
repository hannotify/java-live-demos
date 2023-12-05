package com.infosupport.cdi.topmovies;

import com.infosupport.model.Movie;
import com.infosupport.model.MovieEntity;

import java.util.List;

public interface TopMovies {
    List<MovieEntity> listTopMovies();
}
