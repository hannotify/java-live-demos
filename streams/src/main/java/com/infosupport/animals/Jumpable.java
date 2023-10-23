package com.infosupport.animals;

public interface Jumpable {
    void jump();
    default void walk() {
        printMessage("A Jumpable walks with the owner.");
    }

    default void printMessage(String message) {
        System.out.println(message);
    }
}
