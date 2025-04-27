package com.udemy.java.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VinothPageWithCheckbox {
    private WebDriver driver;

    public VinothPageWithCheckbox(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        this.driver.get(url);
    }

    public void selectCheckBoxes(String gender) {
        List<WebElement> tableRows = this.driver.findElements(By.tagName("tr"));
        tableRows.stream()
                .skip(1)// skip header
                .map(tableRow -> tableRow.findElements(By.tagName("td")))//convert each row element into a list of columns elements
                .filter(listOfColumns -> listOfColumns.size() == 4)// in the new URL provided there is an empty row which will result in a empty list of columns
                .filter(listOfColumns -> listOfColumns.get(1).getText().equalsIgnoreCase(gender))// in each list of column webElements, filter out lists based on the lists second entry value
                .map(listOfColumns -> listOfColumns.get(3).findElement(By.tagName("input")))// conver list of Column elements into one element - we are interested in the fourth entry in List
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }
}
