package com.udemy.java.test;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {
    private static Predicate<WebElement> isBlank= (e) ->{
       return e.getText().trim().isEmpty();
    };

    private static Predicate<WebElement> linkHasS = (e) ->{
        return  e.getText().toLowerCase().contains("s");
    };

    public static List<Predicate> getRules (){
        List<Predicate> rules = new ArrayList<>();
        rules.add(isBlank);
        rules.add(linkHasS);
        return rules;
    }
}
