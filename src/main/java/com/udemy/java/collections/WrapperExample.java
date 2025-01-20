package com.udemy.java.collections;

import java.util.ArrayList;
import java.util.List;

public class WrapperExample {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        int a =4;
        Integer b = 5; // autoboxing
        Integer c = b; // autoboxing
        Integer d = new Integer(6);
        int e = d; // auto unboxing
        list1.add(a);
        list1.add(b);
        list1.add(c);
        list1.add(d);
        list1.add(e);
        System.out.println(list1);
    }
}
