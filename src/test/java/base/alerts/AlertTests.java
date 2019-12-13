package base.alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfuly clicked an alert","Incorrect message");
    }

    @Test
    public void testDismissConfirm(){
        var alertsPage = homePage.clickJavaScriptAlerts();

        alertsPage.triggerConfirm();
        alertsPage.alert_clickToDismiss();
        assertEquals(alertsPage.getResult(),"You clicked: Cancel","Incorrect message");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Incorrect Alert message");
    }

    @Test
    public void testAcceptPrompt(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        var inputText = "Hello what is this";
        alertsPage.triggerPrompt();
        alertsPage.alert_SetInput(inputText);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+inputText,"Incorrect message");
    }
}
