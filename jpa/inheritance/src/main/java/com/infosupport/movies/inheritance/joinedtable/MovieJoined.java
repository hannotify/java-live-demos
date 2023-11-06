package com.infosupport.movies.inheritance.joinedtable;

import jakarta.persistence.Entity;

import java.time.Duration;
import java.time.Year;

@Entity
public class MovieJoined extends VideoJoined {
    private Duration runtime;

    public MovieJoined() {}

    public MovieJoined(String title, Year publicationYear, Duration runtime) {
        super(title, publicationYear);
        this.runtime = runtime;
    }
}
