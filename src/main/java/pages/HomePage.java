package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utils{
    private final WebDriver driver;
    private  List<WebElement> parentelements;
    private By appLogo=By.cssSelector(".app_logo");
    // NOTE: div.inventory_item_description div.inventory_item_label a div.inventory_item_name
    private By parentElements=By.cssSelector(".inventory_item_description");
    private By elementsNames=By.cssSelector("div.inventory_item_label a div.inventory_item_name");
    private By elementsAddButton=By.cssSelector("div.pricebar button");
    private By shopButton =By.cssSelector(".shopping_cart_link");
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public String getTitle() {
        return driver.findElement(appLogo).getText().trim();
    }
    public List<String> getAllElementsFromPropertyFile() throws IOException {

        return getPrportiesFileFroducts("C:\\Users\\a904051\\IdeaProjects\\SwagLabsProject\\src\\main\\java\\resources\\Products.properties");
    }
public List<String> getNamesFromNestedElements(){
       parentelements = driver.findElements(parentElements);
        List<String> names = new ArrayList<String>();

    for (WebElement element : parentelements
         ) {
       names.add(element.findElement(elementsNames).getText().trim());
    }
    return  names;
}
    public void addElementFromNestedElements(){
        parentelements = driver.findElements(parentElements);

        for (WebElement element : parentelements
             ) {
            element.findElement(elementsAddButton).click();
            System.out.println("Button of element " + element.findElement(elementsNames).getText().trim()+"is clicked");

        }
    }
    public void addWantedProdcuts(List<String> prdcts) throws IOException {
        parentelements = driver.findElements(parentElements);

        try{
            waitForvisibility(parentElements);
        }catch (TimeoutException exception){
            throw new IOException("Element not found");
        }
        for (String s : prdcts) {
            WebElement element = parentelements.stream()
                    .filter(el -> el.findElement(elementsNames).getText().equals(s))
                    .findFirst()
                    .orElse(null);

            if (element != null) {
                WebElement button = element.findElement(elementsAddButton);
                // You can now perform actions on the 'button', for example, click it
                button.click();
            }
        }
    }

    public ShoppingCartPage clickShopButton() {
        driver.findElement(shopButton).click();
        return new ShoppingCartPage(driver);
    }
}
