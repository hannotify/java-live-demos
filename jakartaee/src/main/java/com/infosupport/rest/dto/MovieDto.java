package com.infosupport.rest.dto;

import com.infosupport.model.Movie;

public record MovieDto(String name) {
    public static MovieDto fromEntity(Movie movie) {
        return new MovieDto(movie.getName());
    }
}
