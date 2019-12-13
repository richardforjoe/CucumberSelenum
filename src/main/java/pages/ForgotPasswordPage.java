package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By formEmail = By.id("email");
    private By formRetrievePasswordButton = By.id("form_submit");
    private By statusAlert = By.id("flash-messages");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFormEmail(String email){
        driver.findElement(formEmail).sendKeys(email);
    }

    public EmailSentPage clickRetrievePasswordButton(){
        driver.findElement(formRetrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

    public String getAlertText(){
        String statusAlertText = driver.findElement(statusAlert).getText();
        return statusAlertText;
    }
}

