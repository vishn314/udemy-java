package com.udemy.java.compilePolymorphism;

public class AreaCalculator {

    public int getArea(int a){
        return a*a;
    }

    public double getArea(double a){
        return a*a;
    }

    public int getArea(int a, int b){
        return a*b;
    }

}
