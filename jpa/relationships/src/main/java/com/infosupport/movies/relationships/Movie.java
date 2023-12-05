package com.infosupport.movies.relationships;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long movieId;
    private String name;

    @OneToOne
    private Movie prequel;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MovieRating movieRating;

    @OneToMany(mappedBy = "movie")
    private Set<Award> awards = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        joinColumns = {@JoinColumn(name = "movie_id")},
        inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Collection<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public void addAward(Award award) {
        award.setMovie(this);
        awards.add(award);
    }

    public void addActor(Actor actor) {
        actor.addMovie(this);
        actors.add(actor);
    }

    public void setMovieRating(MovieRating rating) {
        rating.setMovie(this);
        movieRating = rating;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setPrequel(Movie prequel) {
        this.prequel = prequel;
    }
}
