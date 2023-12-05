package com.infosupport.rest.dto;

import com.infosupport.model.Movie;
import com.infosupport.model.MovieEntity;

public record MovieDto(String name) {
    public static MovieDto fromEntity(MovieEntity movie) {
        return new MovieDto(movie.getName());
    }
}
