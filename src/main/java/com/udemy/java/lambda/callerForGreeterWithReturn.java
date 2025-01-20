package com.udemy.java.lambda;

import java.util.Locale;

public class callerForGreeterWithReturn {
    public static void main(String[] args) {
        // lambda function returning something
        GreeterWithReturn g1 = (firstName) -> {
            return firstName.toUpperCase();
        };
        String output = g1.greet("gopal");
        System.out.println(output);

        // if its a one line funtion, we can even omit the return keyword, Java will know to return the one liner to whoever is calling.
        GreeterWithReturn g2 = (firstName) -> firstName.toUpperCase(); //implementation
        output = g2.greet("vishnu");// this guy calls
        System.out.println(output);
    }

}
