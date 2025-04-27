package com.udemy.java.test.streams;

import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.udemy.java.pages.VinothPageWithCheckbox;

public class CheckBoxAssignmentWithPageObject {
    private WebDriver driver;
    private VinothPageWithCheckbox page;

    @BeforeTest
    public void initializeDriverAndPage() {
        this.driver = DriverFactory.getDriver("chrome");
        this.page = new VinothPageWithCheckbox(driver);
    }

    @Test(dataProvider = "GenderInput" )
    public void testMethod(String gender) {
        String url = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html";
        page.openURL(url);
        page.selectCheckBoxes(gender);
        System.out.println("did it work breakpoint");
    }

    @DataProvider(name ="GenderInput")
    public String[] genderProvider(){
        return new String[] {"male", "female"};
    }
}
