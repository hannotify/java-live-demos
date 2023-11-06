package com.infosupport.movies.inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.multi.MultiViewportUI;
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
        Movie goodfellas = new Movie("Goodfellas" ,Year.of(1990));
        Movie theGodfather = new Movie("The Godfather", Year.of(1972));
        Series theHauntingOfHillHouse = new Series("The Haunting of Hill House", Year.of(2020), 1);

        Actor marlonBrando = new Actor("Marlon Brando");
        marlonBrando.addEmailAddress(new Email("marlon@hollywood.com"));
        marlonBrando.addEmailAddress(new Email("marlon@corleone.it"));

        theGodfather.addActor(marlonBrando);
        goodfellas.setMovieRating(new MovieRating(9.0));
        theGodfather.setMovieRating(new MovieRating(8.5));

        em.persist(goodfellas);
        em.persist(theGodfather);
        em.persist(theHauntingOfHillHouse);
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