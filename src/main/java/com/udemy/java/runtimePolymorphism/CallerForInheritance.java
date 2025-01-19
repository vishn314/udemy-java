package com.udemy.java.runtimePolymorphism;

public class CallerForInheritance {
    public static void main(String[] args) {
        Animal a = new Dog();
        test(a);
        a = new Cat();
        test(a);
        a = new Horse();
        test(a);
    }

    private static void test(Animal a) {
        a.makeSound();
        a.walk();
    }

}
