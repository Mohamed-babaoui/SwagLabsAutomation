package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public List<String> list = new ArrayList<>();

    @BeforeMethod
    public void setUp() {
        // Common setup code for all test methods
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
