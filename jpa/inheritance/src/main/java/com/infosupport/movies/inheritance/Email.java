package com.infosupport.movies.inheritance;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Email() {}
}
