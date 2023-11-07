package com.infosupport.movies.inheritance.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Year;

public class MovieTableTest {

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
        var goodfellas = new MovieTable("Goodfellas" , Year.of(1990), Duration.ofMinutes(145));
        var theGodfather = new MovieTable("The Godfather", Year.of(1972), Duration.ofMinutes(175));
        var theHauntingOfHillHouse = new SeriesTable("The Haunting of Hill House", Year.of(2020), 1);

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
