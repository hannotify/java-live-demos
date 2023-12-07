package com.infosupport.cdi.topmovies;

import com.infosupport.model.MovieEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopMoviesBeanTest {
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(testOut));
    }

    @DisplayName("printTopMovies() should print a header, followed by the result of the TopMovies implementor")
    @Test
    public void testPrintTopMovies() {
        // Arrange
        var testMovies = List.of(new MovieEntity("Memento"), new MovieEntity("Shawshank Redemption"));
        TopMovies topMoviesMock = Mockito.mock(TopMovies.class);
        Mockito.when(topMoviesMock.listTopMovies()).thenReturn(testMovies);
        TopMoviesBean topMoviesBean = new TopMoviesBean(topMoviesMock);

        // Act
        topMoviesBean.printTopMovies();

        // Assert
        Mockito.verify(topMoviesMock).listTopMovies();
        Assertions.assertThat(testOut.toString()).contains("Top Movies: ");
        Assertions.assertThat(testOut.toString()).contains(testMovies.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}