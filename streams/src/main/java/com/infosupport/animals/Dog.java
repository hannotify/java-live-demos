package com.infosupport.animals;

public class Dog extends Animal implements Jumpable, Walkable {
    @Override
    public void eat() {
        System.out.println("Eating a bone.");
    }

    @Override
    public void jump() {
        printMessage("Jumping in the air!");
    }

    @Override
    public void walk() {
        Walkable.super.walk();
    }
}
