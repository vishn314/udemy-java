package com.udemy.java.streams.introduction;

import java.util.ArrayList;
import java.util.List;

public class Introduction {
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

        int count =0;

        for (int i = 0; i < intList.size() && count <= 2; i++) {
            if (intList.get(i) % 2 == 0) {
                System.out.println(intList.get(i) * intList.get(i));
                count++;
            }
        }

        // Making above simple
        System.out.println("stream");
        intList.stream()
                .filter(i -> i %2 ==0)
                .limit(3)
                .map(i-> i*i)
                .forEach(System.out::println);


        // shows how limit works, we reach limit further filtering does not happen.
        // Also shows we pick the next item only after we process the current item all the way through the terminal operation (ofcourse only when we are within limits)
        System.out.println("stream with debug souts");
        intList.stream()
                .filter(i -> {
                    System.out.println("filter recieved ::" + i);
                    return i %2 ==0;
                })
                .limit(3)
                .map(i -> {
                    System.out.println("map recieved :: "+ i);
                    return i*i;
                })
                .forEach(System.out::println);

        // Shows stream withut terminal - does not even process the steam of data, directly prints the end of program line
        System.out.println("stream without a terminal operation");
        intList.stream()
                .filter(i -> {
                    System.out.println("filter recieved ::" + i);
                    return i %2 ==0;
                })
                .limit(3)
                .map(i -> {
                    System.out.println("map recieved :: "+ i);
                    return i*i;
                });
        //.forEach(System.out::println);
        System.out.println("End of program");
    }

}
