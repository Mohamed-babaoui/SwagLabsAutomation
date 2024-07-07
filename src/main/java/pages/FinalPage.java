package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage {
    private final WebDriver driver;
    private By messageField= By.tagName("h2");

    public FinalPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getMessage(){

      return   driver.findElement(messageField).getText().trim();
    }
}
