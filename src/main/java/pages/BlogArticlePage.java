package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogArticlePage {

    private WebDriver driver;
    private By pageTitle = By.tagName("h1");
    private By blogPostArticleTitle = By.id("hs_cos_wrapper_name");

    public BlogArticlePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public String getBlogPostArticleTitle(){
        return driver.findElement(blogPostArticleTitle).getText();
    }

}
