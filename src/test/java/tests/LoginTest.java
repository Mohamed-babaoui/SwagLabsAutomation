package tests;

import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class LoginTest extends BaseTest {



@Test
    public void loginTest() throws IOException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername("standard_user").enterPassword("secret_sauce");
        HomePage homePage=loginPage.clickLoginButton();
        checkStrings(homePage.getTitle(),"Swag Labs");
        list=homePage.getAllElementsFromPropertyFile();
        homePage.addWantedProdcuts(list);
       ShoppingCartPage shoppingCartPage= homePage.clickShopButton();
       shoppingCartPage.checkElementsExist(list);
       CheckoutPage checkoutPage=shoppingCartPage.goToCheckoutPage();
       OverViewPage overViewPage=checkoutPage.fillFirstName("mohamed").fillLastName("Babaoui").fillPostalCode("20000").gotoOverview();
       FinalPage finalPage=overViewPage.getShippingInfos().finishOperation();
       String message =finalPage.getMessage();
       checkStrings(message,"Thank you for your order!");
    }
}
