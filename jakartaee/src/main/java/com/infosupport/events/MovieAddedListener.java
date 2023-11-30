package com.infosupport.events;

import jakarta.enterprise.event.Observes;

public class MovieAddedListener {
    public void onMovieAdded(@Observes MovieAdded movieAdded) {
        System.out.println("[MovieAddedListener] The following movie was added!");
        System.out.println(movieAdded.movie());
    }
}
