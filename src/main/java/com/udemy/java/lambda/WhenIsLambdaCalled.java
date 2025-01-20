package com.udemy.java.lambda;

import java.util.Locale;

public class WhenIsLambdaCalled {
    public static void main(String[] args) {

        System.out.println("start of main");
        test(a -> {
            System.out.println("Lambda function implementation");
            return "Hello! " + a.toUpperCase();
        });
        System.out.println("end of main");
    }
    private static void test(GreeterWithReturn g1){
        System.out.println("start of test method");
        String returned = g1.greet("vishnu"); // Lambda is only executed when the greet fucntion is called.
        System.out.println(returned);
        System.out.println("end of test method");
    }
}
