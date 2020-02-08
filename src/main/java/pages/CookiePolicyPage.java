package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiePolicyPage {
    private WebDriver driver;

    public CookiePolicyPage(WebDriver driver){
        this.driver = driver;
    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
