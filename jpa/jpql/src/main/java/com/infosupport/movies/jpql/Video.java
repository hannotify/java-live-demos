package com.infosupport.movies.jpql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Year;

@Entity
public abstract class Video {
    @Id @GeneratedValue
    private long id;
    private String title;
    private Year publicationYear;

    public Video() {
    }

    public Video(String title, Year publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}
