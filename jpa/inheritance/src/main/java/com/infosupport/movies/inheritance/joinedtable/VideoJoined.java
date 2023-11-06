package com.infosupport.movies.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.Year;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class VideoJoined {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Year publicationYear;

    public VideoJoined() {
    }

    public VideoJoined(String title, Year publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}
