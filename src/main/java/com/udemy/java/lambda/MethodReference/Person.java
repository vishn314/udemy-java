package com.udemy.java.lambda.MethodReference;

public class Person {
    public void methodInPerson(){
        System.out.println("Hey this is a method from " + this.getClass().getSimpleName());
    }
}
