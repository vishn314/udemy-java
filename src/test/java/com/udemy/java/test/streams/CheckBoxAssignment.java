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

public class CheckBoxAssignment {
    private WebDriver driver;

    @BeforeTest
    public void getDriver() {
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test
    public void testDriver() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");

        // My solution
        List<WebElement> tableRows = this.driver.findElements(By.tagName("tr"));
        tableRows.stream().filter((rows) -> !rows.findElements(By.tagName("td")).isEmpty()) //find rows that have data
                .map(row -> {
                    List<WebElement> tDatum = row.findElements(By.tagName("td"));
                    return tDatum.get(3);
                }).forEach(td -> td.findElement(By.tagName("input")).click());

        System.out.println("check box should be checked");

        //Vinoth's solution
        List<WebElement> checkBoxes = this.driver.findElements(By.tagName("input"));
        checkBoxes.stream().forEach(WebElement::click);

        System.out.println("check box should be un checked");
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
