package base.login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfullLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

                assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),"Alert text is incorrect");
//        assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!\n" +
//                "×","You have successfully logged in");
    }


}
