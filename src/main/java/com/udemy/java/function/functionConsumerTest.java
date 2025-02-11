package com.udemy.java.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class functionConsumerTest {
    public static void main(String[] args) {
        Consumer<Person> personConsumer1 = (person) -> {
            System.out.println("Input reference of personConsumer1 " + person.toString());
            Person p1C = new Person(person.getFirstName(), person.getLastName());
            p1C.setFirstName("personConsumer1" + p1C.getFirstName());
            p1C.setLastName("personConsumer1" + p1C.getLastName());
            System.out.println("after personConsumer1 :: " + p1C.getFirstName() + " " + p1C.getLastName());
            System.out.println("after personConsumer1 :: " + p1C.toString());

        };
        Consumer<Person> personConsumer2 = (person) -> {
            System.out.println("Input reference of personConsumer2 " + person.toString());
            Person p2C = new Person(person.getFirstName(), person.getLastName());
            p2C.setFirstName("personConsumer2" + p2C.getFirstName());
            p2C.setLastName("personConsumer2" + p2C.getLastName());
            System.out.println("after personConsumer2 :: " + p2C.getFirstName() + " " + p2C.getLastName());
            System.out.println("after personConsumer2 :: " + p2C.toString());

        };

        Person consumerInputPerson = new Person("Vishnu", "Gopal");

        personConsumer1.andThen(personConsumer2).accept(consumerInputPerson);
        System.out.println("Output of consumer chaining");
        System.out.println(consumerInputPerson.getFirstName() + " " + consumerInputPerson.getLastName());
        System.out.println("person object ::" + consumerInputPerson.toString());

        System.out.println("****************************************************************");

        Function<Person, Person> personFunction1 = (person) -> {
            System.out.println("Input reference of personFunction1 " + person.toString());
            Person pF1 = new Person(person.getFirstName(), person.getLastName());
            pF1.setFirstName("personFunction1" + pF1.getFirstName());
            pF1.setLastName("personFunction1" + pF1.getLastName());
            System.out.println("after personFunction1 :: " + pF1.getFirstName() + " " + pF1.getLastName());
            System.out.println("after personFunction1 :: " + pF1.toString());
            return pF1;
        };

        Function<Person, Person> personFunction2 = (person) -> {
            System.out.println("Input reference of personFunction2 " + person.toString());
            Person pF2 = null;
            try {
                pF2 = (Person) person.clone();
                pF2.setFirstName("personFunction2" + pF2.getFirstName());
                pF2.setLastName("personFunction2" + pF2.getLastName());
                System.out.println("after personFunction2 :: " + pF2.getFirstName() + " " + pF2.getLastName());
                System.out.println("after personFunction2 :: " + pF2.toString());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            return pF2;
        };

        Person p2 = new Person("Maya", "Ram");
        System.out.println("input person object ::" + p2.toString());
        Person p3 = personFunction1.andThen(personFunction2).apply(p2);

        System.out.println("Output of Function chaining");
        System.out.println(p3.getFirstName() + " " + p3.getLastName());
        System.out.println("output person object ::" + p3.toString());


    }
}
