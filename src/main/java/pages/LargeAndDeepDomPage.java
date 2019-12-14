package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table); // Table to be scrolled to
        String script = "arguments[0].scrollIntoView();"; //Javascript code - scrollIntoView is a javascript method

        //JavascriptExecutor - class, available in selenium. Cast the driver to this executor
        // 2 methods available - executeAsyncScript / executeScript
        // tableElement is replaced with arguments[0] - Java script code is
        /**
         * var element = document.getElementById("large-table");
            element.scrollIntoView();
         **/
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
