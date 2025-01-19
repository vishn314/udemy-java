package com.udemy.java.runtimePolymorphism;

public class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Bow Bow");
    }
}
