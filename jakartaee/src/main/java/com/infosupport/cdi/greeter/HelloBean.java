package com.infosupport.cdi.greeter;

import com.infosupport.cdi.topmovies.TopMoviesBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class HelloBean {
    private Greet greeter;

    @EJB
    private TopMoviesBean topMoviesBean;

    public HelloBean() {
        System.out.println("[HelloBean] in constructor!");
        System.out.println("[HelloBean] Today's top movies;");
    }

    @PostConstruct
    public void printTopMovies() {
        //System.out.println(this);
        topMoviesBean.printTopMovies();
    }

    public Greet getGreeter() {
        return greeter;
    }

    @Inject
    public void setGreeter(Greet greeter) {
        System.out.println("[HelloBean] in setGreeter!");
        this.greeter = greeter;
        System.out.println("[HelloBean] greeter instance injected: " + greeter);
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "greeter=" + greeter +
                '}';
    }
}
