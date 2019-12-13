package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

        private WebDriver driver;
        private By inputField = By.id("target");
        private By resultText = By.id("result");

        public KeyPressesPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterText(String text){
            driver.findElement(inputField).sendKeys(text);
        }

    public void enterAt(){

            enterText(Keys.chord(Keys.SHIFT,"2") + " The At sign");
    }
        public String getResult(){
            return driver.findElement(resultText).getText();
        }



}
