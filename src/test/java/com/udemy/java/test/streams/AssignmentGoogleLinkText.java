package com.udemy.java.test.streams;

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

public class AssignmentGoogleLinkText {
    private WebDriver driver;

    @BeforeTest
    public void getDriver() {
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test
    public void testDriver() {
        this.driver.get("https://www.google.com/");
        // dont allow blanks links
        // dont allow links containing s
        // convert link text to upper case
        //print in console

        List<WebElement> linksInGoogle = this.driver.findElements(By.tagName("a"));


        Predicate<WebElement> isBlank = (e) -> {
            return e.getText().trim().isEmpty();
        };

        Predicate<WebElement> linkHasS = (e) -> {
            Boolean b = (e.getText().toLowerCase().contains("s"));
            return b;
        };

        Consumer<WebElement> printElements = (e) -> {
            System.out.println(e.getText());
        };


        linksInGoogle.stream()
//                .peek(i -> System.out.println("Pre filter " + i.getText()))
                .filter(isBlank.negate())
//                .peek(i -> System.out.println("Pre filter " + i.getText()))
                .filter(linkHasS.negate())
//                .peek(i -> System.out.println("Post filter " + i.getText()))
                .map(i -> i.getText().toUpperCase())
//                .peek(i -> System.out.println("post map  " + i))
                .forEach(System.out::println);

        linksInGoogle.stream()
                .filter(e -> { return !e.getText().trim().isEmpty();})
                .filter(e -> !e.getText().toLowerCase().contains("s"))
                .map(i -> i.getText().toUpperCase())
                .forEach(System.out::println);
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
