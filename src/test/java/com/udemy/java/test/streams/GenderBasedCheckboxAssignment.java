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
                .filter((rows) -> rows.findElements(By.tagName("th")).isEmpty()) //filter out header rows
                .map(row -> {
                    List<WebElement> tDatum = row.findElements(By.tagName("td")); // convert each row into a list of columns
                    System.out.println(tDatum.get(1).getText()); // print gender for a given list object, second entry in list is gender
                    if (tDatum.get(1).getText().equals("Male")) { // if gender is male
                        return tDatum.get(3).findElement(By.tagName("input")); // transform the list into child of the 4th list entry
                    }
                    return tDatum.get(2); // I have to return something that is does not have any impact by clicking on it. This is a return on a td that has nothing but a text.
                })
                .forEach(WebElement::click); // click check box or the dummy text element in "female" occurences

        System.out.println("did it work");

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
