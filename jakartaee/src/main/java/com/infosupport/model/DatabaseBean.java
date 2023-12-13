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

    public Collection<MovieEntity> getAllMovies() {
        return List.of(new MovieEntity("Goodfellas"),
                new MovieEntity("Forrest Gump"),
                new MovieEntity("Notting Hill"),
                new MovieEntity("Barbie")
        );
    }

    public MovieEntity retrieveMovie(Integer id) throws MovieNotFoundException {
        var movie = em.find(MovieEntity.class, id);

        if (movie == null) {
            throw new MovieNotFoundException("Movie not found.");
        }

        return movie;
    }

    public void addMovie(MovieDto movie) {
        em.persist(new MovieEntity(movie.name(), movie.rating(), movie.releaseDate()));
    }

    public void deleteMovie(Integer id) throws MovieNotFoundException {
        em.remove(retrieveMovie(id));
    }
}
