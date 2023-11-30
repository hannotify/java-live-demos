package com.infosupport.cdi.greeter;

import com.infosupport.model.Movie;
import jakarta.enterprise.inject.Produces;

import java.util.List;

public class StringFactory {
    @Produces
    public static List<Movie> movies() {
        return List.of(new Movie("Memento"), new Movie("Shawshank Redemption"));
    }
}
