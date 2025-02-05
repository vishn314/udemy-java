package com.udemy.java.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestClass {
    public static void main(String[] args) {
        Consumer<String> textConsumer = (s) -> System.out.println("I am consuming this string :" + s);
        textConsumer.accept("Vishnu");

        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Maya");
        listOfNames.add("Ram");

        listOfNames.forEach(textConsumer);
    }
}
