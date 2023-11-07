package com.infosupport.movies.inheritance.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

import java.time.Year;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class VideoTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String title;
    private Year publicationYear;

    public VideoTable() {
    }

    public VideoTable(String title, Year publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}
