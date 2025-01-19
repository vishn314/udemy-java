package com.udemy.java.compilePolymorphism;

public class callerMethod {
    public static void main(String[] args) {
        AreaCalculator ac = new AreaCalculator();
        System.out.println(ac.getArea(5));
        System.out.println(ac.getArea(5.5));
        System.out.println(ac.getArea(5,6));
    }
}
