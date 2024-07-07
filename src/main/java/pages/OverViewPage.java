package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OverViewPage extends Utils{
    private final WebDriver driver;
    private By elements = By.cssSelector(".inventory_item_name");
    private By finalPrice = By.cssSelector(".summary_total_label");
    private By paymentinfo = By.xpath("//div[@data-test='payment-info-value']");
    private By shippinginfo = By.xpath("//div[@data-test='shipping-info-value']");
    private By finishButton = By.id("finish");
    private By cancelButton = By.id("cancel");



    public OverViewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public OverViewPage  getShippingInfos() throws IOException {
        Map<String, String> map = new HashMap<>();

        map.put("Total Price", getElementText( finalPrice));
        map.put("Payment Info", getElementText(paymentinfo));
        map.put("Shipping Info", getElementText( shippinginfo));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println( entry.getKey() + ": " + entry.getValue());
        }
        return this;
    }
    private  String getElementText( By locator) throws IOException {
        try{
            waitForvisibility(locator);
        }catch (TimeoutException exception){
            throw new IOException("Element not found");
        }
        return driver.findElement(locator).getText().trim();
    }
    public LoginPage cancel(){
        driver.findElement(cancelButton).click();
        return new LoginPage(driver);
    }


    public FinalPage finishOperation()
    {
        driver.findElement(finishButton).click();
        return new FinalPage(driver);
    }
}

