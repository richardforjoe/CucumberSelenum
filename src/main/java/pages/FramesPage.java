package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SubFramesPages.NestedFramesPage;

public class FramesPage {

        private WebDriver driver;


        public FramesPage(WebDriver driver) {
            this.driver = driver;
        }

    public NestedFramesPage clickNestedFrames(){
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    }
