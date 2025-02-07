package biConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestClass {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumerEnglish = (s, i) -> {
            System.out.println("My name is :" + s);
            System.out.println("My age is :" + i);
        };

        System.out.println("***************Single BiConsumer***************");

        biConsumerEnglish.accept("Vishnu", 35);

        BiConsumer<String, Integer> biConsumerHindi = (s, i) -> {
            System.out.println("Mera nam hai :" + s);
            System.out.println("Mera umar hai :" + i);
        };

        System.out.println("***************BiConsumer Chaining***************");

        BiConsumer<String, Integer> biConsumerMulti = biConsumerEnglish.andThen(biConsumerHindi);

        biConsumerMulti.accept("Gopal", 35);

        System.out.println("***************BiConsumer in Map***************");

        Map<String, Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);

        map.forEach(biConsumerEnglish);
    }
}
