package tests;


import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;



public class WrongCredentialsTest extends BaseTest {

    @Test

    public void wrongCredentialsTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user").enterPassword("secre_sauce").clickLoginButton();
        String message = loginPage.getErrorMessage();
        checkStrings(message,"Epic sadface: Username and password do not match any user in this service");
    }
}
