package com.infosupport.animals;

public interface Walkable {
    default void walk() {
        System.out.println("A Walkable walks with the owner.");
    }
}
