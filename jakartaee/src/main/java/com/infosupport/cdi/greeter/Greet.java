package com.infosupport.cdi.greeter;

import com.infosupport.model.Movie;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateful
public class Greet {
//    @Inject
//    private List<Movie> movies;

    @Override
    public String toString() {
        return "Greet{" +
                "greeting='" + '\'' +
                '}';
    }
}
