package com.udemy.java.lambda;

public class callerMulitLIneGreeter {
    public static void main(String[] args) {
        MultiLineGreetingService mg = ( firstName,  lastName,   age) -> {
            System.out.println("My full name is :" + firstName + " " + lastName);
            System.out.println("My age is :" + age);
            };
        mg.greet("Vishnu", "Raja", 100);
        }
    }

