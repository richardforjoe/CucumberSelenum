package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogArticlePage {

    private WebDriver driver;
    private By pageTitle = By.tagName("h1");

    public BlogArticlePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

}
