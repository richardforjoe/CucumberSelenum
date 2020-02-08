package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage extends HomePage{


    private WebDriver driver;

    public PrivacyPolicyPage(WebDriver driver){
        super(driver);
        //this.driver = driver;
    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}