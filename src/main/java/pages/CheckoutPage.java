package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;
    //
    private By userFirstName=By.id("first-name");
    private By userLastName=By.id("last-name");

    private By userPostalCode=By.id("postal-code");
    private By continueButton=By.id("continue");
    private By cancelButton=By.id("cancel");



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public CheckoutPage fillFirstName(String firstName) {
        driver.findElement(userFirstName).sendKeys(firstName);

        return this;
    }
    public CheckoutPage fillLastName(String lastName) {
        driver.findElement(userLastName).sendKeys(lastName);
        return this;
    }
    public CheckoutPage fillPostalCode(String postalCode) {
        driver.findElement(userPostalCode).sendKeys(postalCode);
        return this;
    }
    public OverViewPage gotoOverview() {
    driver.findElement(continueButton).click();
    return new OverViewPage(driver);
    }
}
