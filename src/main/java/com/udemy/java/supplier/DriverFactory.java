package com.udemy.java.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.function.Supplier;
import java.util.Map;

public class DriverFactory {
    private static final Supplier<WebDriver> firefoxSupplier = FirefoxDriver::new;
    private static final Supplier<WebDriver> chromeSupplier = ChromeDriver::new;
    private static final Map <String, Supplier<WebDriver>> MAP = new HashMap<>();

    static{
        MAP.put("firefox", firefoxSupplier);
        MAP.put("chrome",chromeSupplier);
    }

    public static WebDriver getDriver (String browser){
      return   MAP.get(browser).get();
    }
}
