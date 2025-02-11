package com.udemy.java.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class functionDemo {
    public static void main(String[] args) {
        Function<String, Integer> strLen = String::length;
        Function<Integer, Integer> square = (i) -> i * i;
        System.out.println("Simple example of Function chaining");
        System.out.println(strLen.andThen(square).apply("Hello")); //StrLen -> square is the order of function chaining


        Function<String, String> toUpperFunction = String::toUpperCase;
        Function<String, String> concatenateFunction = "Mr. "::concat;


        Consumer<String> toUpperConsumer= (s) -> System.out.println(s.toUpperCase());
        Consumer<String> concatenateConsumer = (s) -> {
            System.out.println("Mr. ".concat(s));
        };

        System.out.println("***************Consumer Chaining of vishnu***************");
//        Consumer<String> toUpperAndAddPrefixConsumer = toUpperConsumer.andThen(concatenateConsumer);
//        toUpperAndAddPrefixConsumer.accept("vishnu");
        toUpperConsumer.andThen(concatenateConsumer).accept("vishnu"); //this is consumer chaining, this does same as above two lines. Same input for both consumers.

        System.out.println("***************Function Chaining of vishnu***************");
        String functionOutput = toUpperFunction.andThen(concatenateFunction).apply("vishnu"); // ToUpperFunction -> ConcatenateFunction, Output of one function is given as input to the next.
        System.out.println(functionOutput);


        System.out.println("***************Function Chaining of vishnu with Compose ***************");
        functionOutput = toUpperFunction.compose(concatenateFunction).apply("vishnu");// ConcatenateFunction -> ToUpperFunction, Output of one function is given as input to the next.
        System.out.println(functionOutput);

    }
}
