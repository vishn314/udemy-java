package com.udemy.java.test.streams;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GenderBasedCheckboxAssignment {
    private WebDriver driver;

    @BeforeTest
    public void getDriver() {
        this.driver = DriverFactory.getDriver("chrome");
    }
    @Test
    public void testDriver() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");

        List<WebElement> tableRows = this.driver.findElements(By.tagName("tr"));

        tableRows.stream()
                .filter((rows) -> rows.findElements(By.tagName("th")).isEmpty()) //find rows that have data
                .map(row -> {
                            List<WebElement> tDatum = row.findElements(By.tagName("td"));
                            System.out.println(tDatum.get(1).getText());
                            if (tDatum.get(1).getText().equals("Male")){
                                return tDatum.get(3).findElement(By.tagName("input"));
                            }
                            return tDatum.get(2);
                        })
                .forEach(WebElement::click);

        System.out.println("did it work");

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
