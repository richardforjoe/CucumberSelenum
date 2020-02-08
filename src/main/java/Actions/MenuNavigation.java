package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BlogPage;

import java.util.List;

public class MenuNavigation {

    private WebDriver driver;
    private By MenuNavigation = By.cssSelector("li.hs-menu-item.hs-menu-depth-1");

    public MenuNavigation(WebDriver driver){
        this.driver = driver;
    }




}
