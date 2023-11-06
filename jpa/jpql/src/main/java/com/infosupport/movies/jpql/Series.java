package com.infosupport.movies.jpql;

import jakarta.persistence.Entity;

import java.time.Year;

@Entity
public class Series extends Video {
    private int numberOfSeasons;

    public Series() {
    }

    public Series(String title, Year publicationYear, int numberOfSeasons) {
        super(title, publicationYear);
        this.numberOfSeasons = numberOfSeasons;
    }
}
