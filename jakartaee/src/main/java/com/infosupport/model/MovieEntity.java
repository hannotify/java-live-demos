package com.infosupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal rating;
    private LocalDate releaseDate;

    public MovieEntity(String name) {
        this(name, BigDecimal.TEN, LocalDate.now());
    }
    public MovieEntity(String name, BigDecimal rating, LocalDate releaseDate) {
        this.name = name;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public MovieEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
