package com.udemy.java.callable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class callableExample {
    public static void main(String[] args) throws Exception {
        Supplier<Double> doubleSupplier = () -> Math.random();
        Callable<Double> doubleCallable = () -> Math.random();

//        System.out.println(doubleSupplier.get());
//        System.out.println(doubleCallable.call());

        testSupplier(doubleSupplier);
        testCallable(doubleCallable);

    }
    public static void testCallable (Callable c) throws Exception {
        System.out.println(c.call());
    }

    public static void testSupplier (Supplier s)  {
        System.out.println(s.get());
    }

}
