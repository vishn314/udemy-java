package com.udemy.java.collections;

import com.udemy.java.runtimeInterfacePolymorhism.Alarm;
import com.udemy.java.runtimeInterfacePolymorhism.Clock;
import com.udemy.java.runtimeInterfacePolymorhism.GoogleMini;
import com.udemy.java.runtimeInterfacePolymorhism.Iphone;
import com.udemy.java.runtimePolymorphism.Animal;
import com.udemy.java.runtimePolymorphism.Cat;
import com.udemy.java.runtimePolymorphism.Dog;
import com.udemy.java.runtimePolymorphism.Horse;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

public class Caller {
    public static void main(String[] args) {

        System.out.println("************* collection of alarms ****************");
        Clock c = new Clock();
        Iphone i = new Iphone();
        Alarm g = new GoogleMini();
        List<Alarm> list1 = new ArrayList<>();
        list1.add(c);
        list1.add(i);
        list1.add(g);
        doSomethingWithAlarm(list1);

        System.out.println("************* collection of animals ****************");
        Dog a = new Dog();
        Cat ct = new Cat();
        Animal h = new Horse();
        List<Animal> list2 = new ArrayList<>();
        list2.add(a);
        list2.add(ct);
        list2.add(h);
        doSomethingWithAnimal(list2);

    }

    private static void doSomethingWithAlarm(List<Alarm> list1) {
        for(Alarm a : list1){
            a.setAlarm();
        }
    }

    private static void doSomethingWithAnimal(List<Animal> list2) {
        for(Animal a : list2 ){
            a.makeSound();
        }
    }
}
