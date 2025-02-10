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

public class AssignmentRemoveS {
    private WebDriver driver;

    @BeforeTest
    public void getDriver(){
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test
    public void testDriver(){
        this.driver.get("https://www.google.com/");

        List<WebElement> linksInGoogle = this.driver.findElements(By.tagName("a"));

        Predicate<WebElement> isBlank = (e) ->{
            return  e.getText().trim().isEmpty();
        };

        Predicate<WebElement> linkHasS = (e) ->{
            Boolean b = (e.getText().toLowerCase().contains("s"));
            return b;
        };

        Consumer<WebElement> printElements = (e) ->{
            System.out.println(e.getText());
        };

        System.out.println("Before 1 :: " + linksInGoogle.size());

        linksInGoogle.removeIf(isBlank);

        System.out.println("Before 2 :: " + linksInGoogle.size());

        linksInGoogle.removeIf(linkHasS);

        System.out.println("After :: " + linksInGoogle.size());

        // linksInGoogle.removeIf(isBlank.or(linkHasS)); // This also does the same as the above two remove if's

        linksInGoogle.forEach(printElements);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
