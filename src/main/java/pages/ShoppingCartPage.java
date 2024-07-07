package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends Utils {
    private final WebDriver driver;
    private By elements= By.cssSelector(".inventory_item_name");
    private By checkOutButton= By.cssSelector(".checkout_button");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void checkElementsExist(List<String> wantedElements)    {
   List<String> listOfElements=  driver.findElements(elements).stream().map(e ->e.getText()).collect(Collectors.toList());

   if(!listOfElements.containsAll(wantedElements))  {
       throw new AssertionError("Not all elements exist in the shopping cart");
   }

    }
    public void continueShopping(){
        driver.navigate().back();
    }
    public CheckoutPage goToCheckoutPage() throws IOException {

        try{
            waitForvisibility(checkOutButton);
        }catch (TimeoutException exception){
            throw new IOException("Element not found");
        }
        driver.findElement(checkOutButton).click();
        return new CheckoutPage(driver);
    }
}