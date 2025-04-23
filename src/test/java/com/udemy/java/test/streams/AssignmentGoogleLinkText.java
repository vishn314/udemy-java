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

        System.out.println("Piggy backing from earlier methods");
        linksInGoogle.stream()
//                .peek(i -> System.out.println("Pre filter " + i.getText()))
                .filter(isBlank.negate())
//                .peek(i -> System.out.println("Pre filter " + i.getText()))
                .filter(linkHasS.negate())
//                .peek(i -> System.out.println("Post filter " + i.getText()))
                .map(i -> i.getText().toUpperCase())
//                .peek(i -> System.out.println("post map  " + i))
                .forEach(System.out::println);

        System.out.println("write everything fresh");
        linksInGoogle.stream()
                .filter(e -> { return !e.getText().trim().isEmpty();}) // filter non empty elements, notice we have a multi line lambda
                .filter(e -> !e.getText().toLowerCase().contains("s")) // filter out elements containing s
                .map(i -> i.getText().toUpperCase())
                .forEach(System.out::println);

        System.out.println("convert to string first");
        linksInGoogle.stream()
                .map(e ->e.getText())
                .map(e -> e.trim())
                .filter(e -> !e.isEmpty())
                .map(e -> e.toUpperCase())
                .filter(e -> !e.contains("S"))
                .forEach(e -> System.out.println(e));

        System.out.println("convert to string first and use method reference");
        linksInGoogle.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(e -> !e.isEmpty()) // cannot use method reference as we performing ! after method
                .map(String::toUpperCase)
                .filter(e -> !e.contains("S")) // cannot use method reference as we are passing an argument and also using ! operation
                .forEach(System.out::println);

        linksInGoogle = this.driver.findElements(By.tagName("ae2w4r32rd")); // Nothing should be returned

        System.out.println("Stream on empty list");
        linksInGoogle.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(e -> !e.isEmpty()) // cannot use method reference as we performing ! after method
                .map(String::toUpperCase)
                .filter(e -> !e.contains("S")) // cannot use method reference as we are passing an argument and also using ! operation
                .forEach(System.out::println);

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
