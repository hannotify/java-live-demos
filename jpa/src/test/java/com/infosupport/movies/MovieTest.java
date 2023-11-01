package com.infosupport.movies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    private static EntityManager em;

    @BeforeAll
    static void setup() {
        em = Persistence.createEntityManagerFactory("movies").createEntityManager();
    }

    @Test
    void persistMovie() {
        var transaction = em.getTransaction();
        transaction.begin();

        Movie goodfellas = new Movie("Goodfellas");
        Movie theGodfather = new Movie("The Godfather");

        em.persist(goodfellas);
        em.persist(theGodfather);

        transaction.commit();
    }

    @AfterAll
    static void tearDown() {
        em.close();
    }
}