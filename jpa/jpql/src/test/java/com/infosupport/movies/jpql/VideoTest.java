package com.infosupport.movies.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoTest {

    private void persistTestData() {
        Movie goodfellas = new Movie("Goodfellas" , Year.of(1990));
        Movie theGodfather = new Movie("The Godfather", Year.of(1972));
        Movie nottingHill = new Movie("Notting Hill", Year.of(1999));
        Series theHauntingOfHillHouse = new Series("The Haunting of Hill House", Year.of(2020), 1);

        Actor marlonBrando = new Actor("Marlon Brando");
        Actor alPacino = new Actor("Al Pacino");
        marlonBrando.addEmailAddress(new Email("marlon@hollywood.com"));
        marlonBrando.addEmailAddress(new Email("marlon@corleone.it"));
        alPacino.addEmailAddress(new Email("al@pacino.com"));

        theGodfather.addActor(marlonBrando);
        theGodfather.addActor(alPacino);

        goodfellas.setMovieRating(new MovieRating(9.0));
        theGodfather.setMovieRating(new MovieRating(8.5));
        nottingHill.setMovieRating(new MovieRating(3.0));

        em.persist(goodfellas);
        em.persist(theGodfather);
        em.persist(theHauntingOfHillHouse);
        em.persist(nottingHill);
    }

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
        // empty database

        persistTestData();
        transaction.commit();
        transaction.begin();
    }

    /**
     * Voorbeeld-naamgevingsconventie voor unit-tests.
     */
    @Test
    @Disabled
    void retrieveSeries_withASelectAllQuery_shouldReturn1Series() {
        // Arrange
        // var parameters = ...;

        // Act
        // var series = retrieveSeries(parameters)

        // Assert
        // assertTrue(series.size() == 1);
    }

    @Test
    void selectAllSeries_shouldReturn1Series() {
        // Arrange
        TypedQuery<Series> query = em.createQuery("SELECT s FROM Series s", Series.class);

        // Act
        var videos = query.getResultList();

        // Assert
        assertEquals(1, videos.size());
    }

    @Test
    void selectAllVideos() {
        // Arrange
        TypedQuery<Video> query = em.createQuery("SELECT v FROM Video v", Video.class);

        // Act
        var videos = query.getResultList();

        // Assert
        assertEquals(3, videos.size());

        var movieOrSeries = videos.get(0);

        assertTrue(movieOrSeries instanceof Movie || movieOrSeries instanceof Series);
    }

    @Test
    void selectAllMovies_withMinimumRatingOf8_shouldReturn2Movies() {
        // Arrange
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.movieRating.rating > 8.0", Movie.class);

        // Act
        var movies = query.getResultList();
        System.out.println(movies);

        // Assert
        assertEquals(2, movies.size());
    }

    @Test
    void updateQuery_whichIncreasesRatingBy1_5_shouldResultInIncreasedRatings() {
        Query query = em.createQuery("""
            UPDATE Movie m
            SET m.movieRating.rating = m.movieRating.rating + 1.5
            WHERE m.movieRating.rating < 8.0
        """);

        int affectedRows = query.executeUpdate();

        System.out.println(affectedRows + " affected.");
        assertEquals(1, affectedRows);

        TypedQuery<Movie> selectQuery = em.createQuery("SELECT m FROM Movie m WHERE m.movieRating.rating = 4.5", Movie.class);
        assertEquals(1, selectQuery.getResultList().size());
    }

    @Test
    void updateQuery_whichIncreasesRatingBy1_5_shouldResultInIncreasedRatingsWithFluentAssertions() {
        Query query = em.createQuery("""
            UPDATE Movie m
            SET m.movieRating.rating = m.movieRating.rating + 1.5
            WHERE m.movieRating.rating < 8.0
        """);

        int affectedRows = query.executeUpdate();

        System.out.println(affectedRows + " affected.");
        assertThat(affectedRows).isEqualTo(1);

        TypedQuery<Movie> selectQuery = em.createQuery("SELECT m FROM Movie m WHERE m.movieRating.rating = 4.5", Movie.class);
        assertThat(selectQuery.getResultList().size()).isEqualTo(1);
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
