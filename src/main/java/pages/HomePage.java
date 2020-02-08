package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class HomePage {

    private WebDriver driver;

    private By pageTitle = By.tagName("h1");
    private By blogArticle = By.cssSelector("div.hs-rss-item p a");
    private By menuNavigation = By.cssSelector("li.hs-menu-item.hs-menu-depth-1");
    private By blogSection = By.cssSelector("div.row-fluid-wrapper.row-depth-1.row-number-68");
    private By cookie = By.cssSelector("#hs-eu-confirmation-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }



    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }



    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    private void clickBlogPost(int blogNumber){
        List<WebElement> blogArticles = driver.findElements(blogArticle);
        System.out.println(blogArticles.size());
        blogArticles.get(blogNumber).click();
    }

    private void selectMainMenu(String menu){
        List<WebElement> menuItems = driver.findElements(menuNavigation);
        System.out.println(menuItems.size());

        switch (menu) {
            case "Services":
                menuItems.get(0).click();
                break;
            case "Blog":
                menuItems.get(5).click();
                break;
            default:
                System.out.println("No menu item selected");
                break;
        }
    }


    public void clickCookieBanner(){
        driver.findElement(cookie).click();
    }

    public ServicesPage clickWhatWeOffer(){
        driver.findElement(By.id("#cta_button_2612720_07095d9d-7233-4f7f-b54f-352882b58d73")).click();
    return new ServicesPage(driver);
    }


    public PrivacyPolicyPage clickPrivacyPolicy(){
        clickLink("Privacy Policy");
        return new PrivacyPolicyPage(driver);}

    public CookiePolicyPage clickCookiePolicy(){
        clickLink("Cookie Policy");
        return new CookiePolicyPage(driver);}

    public BlogPage clickBlogMenu(){
        selectMainMenu("Blog");
        return new BlogPage(driver);}

    public void scrollToSection(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView();";
        WebElement element = driver.findElement(blogSection);
        System.out.println("The element is" + element);
        js.executeScript(script, element);
    }


    public BlogArticlePage clickFirstBlog(){
        clickBlogPost(1);
    return new BlogArticlePage(driver);}

}
