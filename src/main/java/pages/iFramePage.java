package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class iFramePage {

        private WebDriver driver;
        private String editorIframeId = "mce_0_ifr";
        private By textArea = By.id("tinymce");
        private By increaseIndentButton = By.cssSelector("#mceu_11 button");
        private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

        public iFramePage(WebDriver driver) {

            this.driver = driver;
        }

        public void clearTextArea(){
            switchToEditArea();
            driver.findElement(textArea).clear();
            switchToMainArea();
            }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    private void switchToEditArea(){
            driver.switchTo().frame(editorIframeId);
        }

    public void increaseIndention(){
        driver.findElement(increaseIndentButton);
    }
    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton);
    }

    private void switchToMainArea(){
            driver.switchTo().parentFrame();
        }
    public String getTextFromEditor(){
            switchToEditArea();
            String text = driver.findElement(textArea).getText();
            switchToMainArea();
        return text;
    }

    }

