package base.login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickRetrievePassword();

        forgotPasswordPage.setFormEmail("test@test.com");

        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();

        assertEquals(emailSentPage.getAlertText(),"Your e-mail's been sent!","Your email was successfully reset");
        //assertTrue(emailSentPage.getAlertText().contains("Your e-mail's been sent!"),"Alert text is incorrect");

    }
}
