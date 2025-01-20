package com.udemy.java.lambda;

public class ReturnLambdaExample {
    public static void main(String[] args) {
        System.out.println("First Example");
        GreeterWithReturn g = getLambda();
        processLambda(g);
        System.out.println("Another example");
        processLambda(getLambda());

    }

    private static GreeterWithReturn getLambda() {
        GreeterWithReturn g = a -> {
            return "Hello ! " + a.toUpperCase();
        };
        return g;
    }

    private static void processLambda(GreeterWithReturn g) {
        String returnedString = g.greet("vishnu");
        System.out.println(returnedString);
    }
}
