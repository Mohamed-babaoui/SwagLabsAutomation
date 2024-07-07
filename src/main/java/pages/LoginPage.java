package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends Utils{
    private WebDriver driver;
    private By userNameField=By.id("user-name");
    private By passwordField=By.id("password");
    private By loginButton=By.id("login-button");
    private By errorMessage=By.tagName("h3");


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;

    }



    public LoginPage enterUsername(String name) {

        waitForvisibility(userNameField);

        driver.findElement(userNameField).sendKeys(name);
                return this;
    }
    public LoginPage enterPassword(String password) {


        waitForvisibility(passwordField);
        driver.findElement(passwordField).sendKeys(password);
        return this;

    }
    public HomePage clickLoginButton() throws IOException {
        WebElement clickElement=driver.findElement(loginButton);
        try{
            waitForElementToBeClickable(clickElement);
        }catch (TimeoutException exception){
            throw new IOException("Element not found");
        }
        clickElement.click();
        return new HomePage(driver);
    }
    public String getErrorMessage() throws IOException {
        try{
            waitForvisibility(errorMessage);
        }catch (TimeoutException exception){
            throw new IOException("Element not found");
        }

        return driver.findElement(errorMessage).getText().trim();
    }
    public String amILoginPage(){

       return driver.getCurrentUrl();
    }

}
