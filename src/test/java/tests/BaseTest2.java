package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class BaseTest2 {
    public WebDriver driver;
    public List<String> list = new ArrayList<>();
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        // Common setup code for all test methods
        String browserName = (browser != null) ? browser : System.getProperty("browser");

        driver = DriverFactory.createDriver(browserName);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public void checkStrings(String string1, String string2) {
        Assert.assertTrue(string1.equalsIgnoreCase(string2), "Strings are not equal");
    }


    @AfterMethod
    public void tearDown() {
        // Common teardown code for all test methods
        if (driver != null) {
            driver.quit();
        }
    }
}
