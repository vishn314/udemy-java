package com.udemy.java.test;


import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.function.Consumer;

public class DriverTestWithConsumer {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional ("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }
    @Test
    public void TestDriver(){
        this.driver.get("https://stackoverflow.com/");

        Consumer<WebElement> webElementConsumer = (e) -> {
            if (!e.getText().isEmpty()){
                System.out.println(e.getText());
            }
        };
        System.out.println("List of links in the webpage: ");
        this.driver.findElements(By.tagName("a"))
                .forEach(webElementConsumer);
        System.out.println("#########End of File###########");
    }

    @AfterTest
    public void quitDriver(){
        this.driver.close();
        this.driver.quit();
    }
}
