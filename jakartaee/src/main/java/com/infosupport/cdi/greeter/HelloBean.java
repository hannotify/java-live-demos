package com.infosupport.cdi.greeter;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class HelloBean {
    private Greet greeter;
    private String test;

    public HelloBean() {
        System.out.println("[HelloBean] in constructor!");
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
                ", test='" + test + '\'' +
                '}';
    }
}
