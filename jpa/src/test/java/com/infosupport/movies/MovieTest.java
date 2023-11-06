package com.infosupport.movies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

class MovieTest {
    private static EntityManager em;
    private EntityTransaction transaction;

    @BeforeAll
    static void setup() {
        em = Persistence.createEntityManagerFactory("movies").createEntityManager();
    }

    @BeforeEach
    void beforeEach() {
        transaction = em.getTransaction();
        transaction.begin();
    }

    @Test
    void persistMovie() {
        Movie goodfellas = new Movie("Goodfellas");
        Movie theGodfather = new Movie("The Godfather");

        em.persist(goodfellas);
        em.persist(theGodfather);
    }

    @Test
    void persistMovieWithRatings() {
        Movie flowerMoon = new Movie("Killings of the Flower Moon");
        flowerMoon.setRating(new MovieRating(8.0));

        em.persist(flowerMoon);
        em.persist(flowerMoon.getMovieRating());
    }

    @Test
    void persistMovieRating() {
        Movie flowerMoon = new Movie("Killings of the Flower Moon");
        MovieRating rating = new MovieRating(8.0);
        flowerMoon.setRating(rating);

        em.persist(rating);
        em.persist(flowerMoon);
    }

    @Test
    void persistMovieAwards() {
        Movie oppenheimer = new Movie("Oppenheimer");
        Award bestMovie2023 = new Award(Year.of(2023), "Best Movie");

        oppenheimer.addAward(bestMovie2023);

        em.persist(oppenheimer);
        em.persist(bestMovie2023);
    }

    @AfterEach
    void afterEach() {
        transaction.commit();
    }

    @AfterAll
    static void tearDown() {
        em.close();
    }
}