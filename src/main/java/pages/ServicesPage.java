package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicesPage  {
    private WebDriver driver;

    public ServicesPage(WebDriver driver){

        this.driver = driver;
    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
