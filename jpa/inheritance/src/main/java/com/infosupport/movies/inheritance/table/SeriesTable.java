package com.infosupport.movies.inheritance.table;

import jakarta.persistence.Entity;

import java.time.Year;

@Entity
public class SeriesTable extends VideoTable {
    private int numberOfSeasons;

    public SeriesTable() {
    }

    public SeriesTable(String title, Year publicationYear, int numberOfSeasons) {
        super(title, publicationYear);
        this.numberOfSeasons = numberOfSeasons;
    }
}
