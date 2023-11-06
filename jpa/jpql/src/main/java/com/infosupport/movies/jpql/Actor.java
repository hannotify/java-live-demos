package com.infosupport.movies.jpql;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Actor {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ElementCollection
    private Collection<Email> emailAddresses = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    private Collection<Movie> movies = new HashSet<>();

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    public void addEmailAddress(Email emailAddress) {
        emailAddresses.add(emailAddress);
    }
}
