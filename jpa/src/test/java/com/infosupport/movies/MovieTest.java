package com.infosupport.movies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void persistMovie() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("movies");
        EntityManager em = emf.createEntityManager();
        Movie goodfellas = new Movie("Goodfellas");
        em.persist(goodfellas);
    }
}