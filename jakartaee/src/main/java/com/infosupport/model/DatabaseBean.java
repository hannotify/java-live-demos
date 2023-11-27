package com.infosupport.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

@Stateless
public class DatabaseBean {
    @PersistenceContext(unitName = "movies")
    EntityManager em;

    public Collection<Movie> getAllMovies() {
        return List.of(new Movie("Goodfellas"),
                new Movie("Forrest Gump"),
                new Movie("Notting Hill"),
                new Movie("Barbie")
        );
    }

    public void addMovie(String name) {
        em.persist(new Movie(name));
    }
}
