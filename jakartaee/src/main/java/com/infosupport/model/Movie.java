package com.infosupport.model;

import java.io.Serializable;
import java.util.Set;

public record Movie(String name, Set<Actor> actors) implements Serializable {
}
