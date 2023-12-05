package com.infosupport.cdi.greeter;

import com.infosupport.model.MovieEntity;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;

import java.util.List;

@Stateful
public class Greet {
    @Inject
    private List<MovieEntity> movies;

    @Override
    public String toString() {
        return "Greet{" +
                "greeting='" + movies.get(0) + '\'' +
                '}';
    }
}
