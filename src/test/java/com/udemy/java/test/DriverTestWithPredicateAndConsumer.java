package com.udemy.java.test;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DriverTestWithPredicateAndConsumer {
    private WebDriver driver;
    @BeforeTest
    public void setDriver(){
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test
    public void testDriver(){
        this.driver.get("https://www.google.com/");
        List<WebElement> linksInGoogle = this.driver.findElements(By.tagName("a"));

        Predicate <WebElement> isBlank = (e) ->{
           return e.getText().trim().isEmpty();
        };

        Consumer<WebElement> printElementText = (e) -> {
            System.out.println(e.getText());
        };

        System.out.println("Before :: " + linksInGoogle.size());

        linksInGoogle.removeIf(isBlank);

        System.out.println("After :: " + linksInGoogle.size());

        linksInGoogle.forEach(printElementText);


    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
