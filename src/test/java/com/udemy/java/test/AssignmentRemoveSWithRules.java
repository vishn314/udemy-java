package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.udemy.java.test.Rules;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AssignmentRemoveSWithRules {
    private WebDriver driver;

    @BeforeTest
    public void getDriver(){
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test
    public void testDriver(){
        this.driver.get("https://www.google.com/");

        List<WebElement> linksInGoogle = this.driver.findElements(By.tagName("a"));

        Consumer<WebElement> printElements = (e) -> {
            System.out.println(e.getText());
        };

        List<Predicate> rules = Rules.getRules();

        rules.forEach((rule) -> {
            linksInGoogle.removeIf(rule);
        });

        System.out.println("After :: " + linksInGoogle.size());


        linksInGoogle.forEach(printElements);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
