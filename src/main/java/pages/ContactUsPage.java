package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends HomePage {
        private WebDriver driver;
        private By firstNameField = By.name("firstname");
        private By lastNameField = By.name("lastname");
        private By emailField = By.name("email");
        private By phoneField = By.name("phone");
        private By messageField = By.name("message");
        private By communiationLegalField = By.name("LEGAL_CONSENT.subscription_type_2963106");
    private By personalDataLegalField = By.name("LEGAL_CONSENT.processing");

        public ContactUsPage(WebDriver driver){
            super(driver);
            //this.driver = driver;
        }


        private void clickLink(String linkText){
            driver.findElement(By.linkText(linkText)).click();
        }

    }
