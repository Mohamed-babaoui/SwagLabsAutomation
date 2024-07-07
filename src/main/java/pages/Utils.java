package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Utils {
    WebDriver driver;
    Properties properties = new Properties();


    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForvisibility(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitForElementToBeClickable(WebElement element)
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public List<String> getPrportiesFileFroducts(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        String items = properties.getProperty("items");

        // Splitting the items into a list
        return  Arrays.asList(items.split("\\s*,\\s*"));

    }
}
