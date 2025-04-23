package com.udemy.java.streams.introduction;

import java.util.ArrayList;
import java.util.List;

public class skipAndMultiStatements {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);

        intList.stream()
                .skip(3)
//                .peek(i -> System.out.println("after skipping " + i))
                .filter(i -> i % 2 == 0)
                .filter(i -> i <= 7)
                .peek(i -> System.out.println("after filtering " + i))
                .map(i -> i * i)
                .map(i -> i + 2)
                .forEach(System.out::println);
    }
}
