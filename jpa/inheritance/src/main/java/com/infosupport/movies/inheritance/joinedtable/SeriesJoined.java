package com.infosupport.movies.inheritance.joinedtable;

import jakarta.persistence.Entity;

import java.time.Year;

@Entity
public class SeriesJoined extends VideoJoined {
    private int numberOfSeasons;

    public SeriesJoined() {
    }

    public SeriesJoined(String title, Year publicationYear, int numberOfSeasons) {
        super(title, publicationYear);
        this.numberOfSeasons = numberOfSeasons;
    }
}
