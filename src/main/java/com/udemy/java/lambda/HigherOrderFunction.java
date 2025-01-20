package com.udemy.java.lambda;

import java.util.Locale;

public class HigherOrderFunction {
    public static void main(String[] args) {

        test((a) -> System.out.println(a.toUpperCase()));
        test(a -> System.out.println(a.toLowerCase()));

        test2(a -> a.toUpperCase());
        test2(a -> a.toLowerCase());

    }

    private static void test(GreetingService g) {
        g.greet("vishnu");
    }

    private static void test2(GreeterWithReturn g2){
        String returned = g2.greet("gopal");
        System.out.println(returned);
    }
}
