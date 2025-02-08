package com.udemy.java.predicate;

import java.util.function.Predicate;

public class SimpleTest {
    public static void main(String[] args) {
        Predicate<Integer> isGreaterThan2 = (n) -> n > 2;
        Predicate<Integer> isLessThan10 = (n) -> n < 10;
        System.out.println(isGreaterThan2.test(3));//true
        System.out.println(isGreaterThan2.test(1));//false
        System.out.println(isLessThan10.test(6));//true
        System.out.println(isGreaterThan2.and(isLessThan10).test(8));//true
        System.out.println(isGreaterThan2.and(isLessThan10).test(80));//false

        Predicate<Integer> isBetween2And10 = isGreaterThan2.and(isLessThan10);

        System.out.println(isBetween2And10.test(8));//true
        System.out.println(isBetween2And10.test(80));//false
    }
}
