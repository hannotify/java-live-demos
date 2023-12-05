package com.infosupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public MovieEntity(String name) {
        this.name = name;
    }

    public MovieEntity() {

    }

    public String getName() {
        return name;
    }
}
