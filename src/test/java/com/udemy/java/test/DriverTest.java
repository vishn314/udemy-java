package com.udemy.java.test;


import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional ("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }
    @Test
    public void TestDriver(){
        this.driver.get("https://stackoverflow.com/");
    }

    @AfterTest
    public void quitDriver(){
        this.driver.close();
        this.driver.quit();
    }
}
