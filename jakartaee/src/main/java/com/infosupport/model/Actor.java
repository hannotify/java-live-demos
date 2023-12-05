package com.infosupport.model;

import java.io.Serializable;

public record Actor(String firstName, String lastName) implements Serializable {
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
