package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class BlogPage {
    private WebDriver driver;
    private By pageTitle = By.tagName("h1");
    private By blogArticles = By.cssSelector(".post-item");

    public BlogPage(WebDriver driver){
        this.driver = driver;
    }


    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public int getTotalBlogDisplayed(){
        List<WebElement> totalBlogs = driver.findElements(blogArticles);
        System.out.println(totalBlogs.size());
        return totalBlogs.size();
    }
}
