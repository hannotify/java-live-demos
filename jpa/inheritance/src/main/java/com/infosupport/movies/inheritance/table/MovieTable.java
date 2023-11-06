package com.infosupport.movies.inheritance.table;

import jakarta.persistence.Entity;

import java.time.Duration;
import java.time.Year;

@Entity
public class MovieTable extends VideoTable {
    private Duration runtime;

    public MovieTable() {}

    public MovieTable(String title, Year publicationYear, Duration runtime) {
        super(title, publicationYear);
        this.runtime = runtime;
    }
}
