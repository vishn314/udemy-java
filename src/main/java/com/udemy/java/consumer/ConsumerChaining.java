package com.udemy.java.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String[] args) {
        Consumer<String> DBConsumer = (s) -> System.out.println("I am writing in DB :" + s);
        Consumer<String> LogConsumer = (s) -> System.out.println("I am writing in log file :" + s);
        Consumer<String> alertConsumer = (s) -> System.out.println("I am alerting in Alert window :" + s);
        Consumer<String> DBLogAlertConsumer = DBConsumer.andThen(LogConsumer).andThen(alertConsumer); // chaining a consumer

        System.out.println("using the accept method of consumer");

        // using the accept method of consumer
        String a = "alpha";
        DBLogAlertConsumer.accept(a);


        System.out.println("######################################");

        System.out.println("The below is an example of passing a list's entries to a consumer - list is a list of strings here");
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("vishnu");
        listOfNames.add("gopal");

        listOfNames.forEach(DBLogAlertConsumer); // using a chained consumer

        System.out.println("######################################");

        System.out.println("The below is an example of passing a list's entries to a consumer - list is a list of strings here");
        // we are using a Map, so we can get the type of consumer based on the key. This avoids the use of if else loops here.
        Map<String, Consumer<String>> mapOfConsumers = new HashMap<>();
        mapOfConsumers.put("db", DBConsumer);
        mapOfConsumers.put("log", LogConsumer);
        mapOfConsumers.put("dbLog", DBLogAlertConsumer);

        listOfNames.forEach(mapOfConsumers.get("dbLog"));

    }
}
