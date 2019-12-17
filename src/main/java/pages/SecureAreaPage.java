package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends HomePage{

    private WebDriver driver;
    private By statusAlert = By.id("flash");


    //public SecureAreaPage(WebDriver driver) {
    //    this.driver = driver;
    //}

    public String getAlertText(){
        String statusAlertText = driver.findElement(statusAlert).getText();
        return statusAlertText;
    }
}
