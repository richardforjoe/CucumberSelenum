package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegrationsPage {



        private WebDriver driver;

        public IntegrationsPage (WebDriver driver){

            this.driver = driver;
        }


        private void clickLink(String linkText){
            driver.findElement(By.linkText(linkText)).click();
        }

    }
