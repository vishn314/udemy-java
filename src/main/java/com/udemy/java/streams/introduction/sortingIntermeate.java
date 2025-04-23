package com.udemy.java.streams.introduction;

import java.util.ArrayList;
import java.util.List;

public class sortingIntermeate {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(8);
        intList.add(6);
        intList.add(3);
        intList.add(4);
        intList.add(9);
        intList.add(1);
        intList.add(5);
        intList.add(2);
        intList.add(7);

        // option 1
        intList.stream()
                .sorted()
//                .peek(i -> System.out.println("Input "+i))
                .filter(i -> i %2 ==0)
//                .peek(i -> System.out.println("post Filter "+i))
                .limit(3)
                .peek(i -> System.out.println("pre-map input "+i))
                .map(i -> i*i)
//                .peek(i -> System.out.println("post map "+i))
        .forEach(System.out::println);
        System.out.println("End of program ********************************");

        // option 2
        intList.stream()
//                .peek(i -> System.out.println("Input "+i))
                .filter(i -> i %2 ==0)
//                .peek(i -> System.out.println("post Filter "+i))
                .limit(3)
                .sorted()
                .peek(i -> System.out.println("pre-map input "+i))
                .map(i -> i*i)
//                .peek(i -> System.out.println("post map "+i))
                .forEach(System.out::println);
        System.out.println("End of program ********************************");

    }
}
