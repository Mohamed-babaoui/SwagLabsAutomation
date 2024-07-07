package tests;

import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;


public class CancelPaymentTest extends BaseTest {

    @Test(description = " check cancel payment operation")


    public void cancelPaymentTest() throws IOException {

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
        String loginPageURL = overViewPage.cancel().amILoginPage();
        checkStrings(loginPageURL,"https://www.saucedemo.com/inventory.html");
    }
}
