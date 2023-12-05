package com.infosupport.cdi.greeter;

import com.infosupport.model.Movie;
import com.infosupport.model.MovieEntity;
import jakarta.enterprise.inject.Produces;

import java.util.List;

public class StringFactory {
    @Produces
    public static List<MovieEntity> movies() {
        return List.of(new MovieEntity("Memento"), new MovieEntity("Shawshank Redemption"));
    }
}
