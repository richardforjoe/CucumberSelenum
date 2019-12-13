package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {

    private WebDriver driver;
    private By statusAlert = By.cssSelector("#content.large-12.columns");


    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText(){
        String statusAlertText = driver.findElement(statusAlert).getText();
        return statusAlertText;
    }

}
