package com.infosupport.model;

import com.infosupport.cdi.greeter.HelloBean;
import com.infosupport.cdi.topmovies.TopMoviesBean;
import com.infosupport.exception.MovieNotFoundException;
import jakarta.ejb.Stateless;
import jakarta.el.MethodNotFoundException;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

@Stateless
public class DatabaseBean {
    @PersistenceContext(unitName = "movies")
    EntityManager em;

    @Inject
    HelloBean bean;

    public Collection<Movie> getAllMovies() {
        return List.of(new Movie("Goodfellas"),
                new Movie("Forrest Gump"),
                new Movie("Notting Hill"),
                new Movie("Barbie")
        );
    }

    public Movie retrieveMovie(Integer id) throws MovieNotFoundException {
        var movie = em.find(Movie.class, id);

        if (movie == null) {
            throw new MovieNotFoundException("Movie not found.");
        }

        return movie;
    }

    public void addMovie(String name) {
        em.persist(new Movie(name));
    }

    public void deleteMovie(Integer id) throws MovieNotFoundException {
        em.remove(retrieveMovie(id));
    }
}
