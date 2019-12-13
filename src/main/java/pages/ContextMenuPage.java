package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By hotSpot = By.id("hot-spot");


    public ContextMenuPage(WebDriver driver) {
            this.driver = driver;
        }

        //actions class
    public void rightClickHotSpot(){
            Actions actions = new Actions(driver);
            actions.contextClick(driver.findElement(hotSpot)).perform();
    }

    public String getPopUpText(){
        return driver.switchTo().alert().getText();
    }

    public void acceptPopUp(){
        driver.switchTo().alert().accept();
    }
    }
