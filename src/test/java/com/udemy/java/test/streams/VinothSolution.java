package com.udemy.java.test.streams;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class VinothSolution {
    private WebDriver driver;

    @BeforeTest
    public void getDriver() {
        this.driver = DriverFactory.getDriver("chrome");
    }

    @Test(dataProvider = "genderInputDataProvider")
    public void testDriver(String gender) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        List<WebElement> tableRows = this.driver.findElements(By.tagName("tr"));
        tableRows.stream()
                .skip(1)// skip header
                .map(tableRow -> tableRow.findElements(By.tagName("td"))) //convert each row element into a list of columns elements
                .filter(listOfColumns -> listOfColumns.get(1).getText().equalsIgnoreCase(gender))// in each list of column webElements, filter out lists based on the lists second entry value
                .map(listOfColumns -> listOfColumns.get(3).findElement(By.tagName("input")))// conver list of Column elements into one element - we are interested in the fourth entry in List
                .forEach(WebElement::click);
        System.out.println("did it work");
    }

    @DataProvider(name = "genderInputDataProvider")
    public String[] genderInput() {
        String[] dataInput = new String[]{"male", "female"};
        return dataInput;
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
