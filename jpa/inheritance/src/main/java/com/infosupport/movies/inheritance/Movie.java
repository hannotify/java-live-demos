package com.infosupport.movies.inheritance;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie extends Video {
    @OneToOne
    private Movie prequel;

    @Embedded
    private MovieRating movieRating;

    @OneToMany(mappedBy = "movie")
    private Set<Award> awards = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        joinColumns = {@JoinColumn(name = "movie_id")},
        inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Collection<Actor> actors = new ArrayList<>();

    public Movie() {}

    public Movie(String title, Year publicationYear) {
        super(title, publicationYear);
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
        movieRating = rating;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setPrequel(Movie prequel) {
        this.prequel = prequel;
    }
}
