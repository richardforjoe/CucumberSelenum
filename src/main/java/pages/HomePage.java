package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


public class HomePage {

    private WebDriver driver;

    private By pageTitle = By.tagName("h1");
    private By searchButtonMainMenu = By.cssSelector("li .search-trigger ");

    private By blogArticle = By.cssSelector("div.hs-rss-item p a");
    private By blogArticleTitle = By.cssSelector("div.hs-rss-item .hs-rss-title");
    private By menuNavigation = By.cssSelector("li.hs-menu-item.hs-menu-depth-1");
    private By blogSection = By.cssSelector("div.row-fluid-wrapper.row-depth-1.row-number-68");
    private By cookie = By.cssSelector("#hs-eu-confirmation-button");

    public String getCurrentblogPostTitle() {
        return currentblogPostTitle;
    }

    private String currentblogPostTitle = "";

    public void setCurrentblogPostTitle(int blogNumber) {
        this.currentblogPostTitle = getBlogPostTitle(blogNumber);
        System.out.println(currentblogPostTitle);
    }



    public HomePage(WebDriver driver){
        this.driver = driver;
    }



    public SearchPage searchForATerm(String searchString){
        selectMainMenu("Search");
        SearchBox searchBox = new SearchBox(driver);
        searchBox.setSearchTerm(searchString);

    return searchBox.hitSearch();}



    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }

    private String getBlogPostTitle(int blogNumber){
        List<WebElement> blogArticles = driver.findElements(blogArticleTitle);
        System.out.println(blogArticles.size());
        return blogArticles.get(blogNumber).getText();
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    private void clickBlogPost(int blogNumber){
        List<WebElement> blogArticles = driver.findElements(blogArticle);
        System.out.println(blogArticles.size());
        setCurrentblogPostTitle(blogNumber);
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
            case "Search":
                menuItems.get(6).click();
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


    public BlogArticlePage clickBlog(String blogNumber) {
        switch (blogNumber) {
            case "first":
                clickBlogPost(0);
                return new BlogArticlePage(driver);
            case "second":
                clickBlogPost(1);
                return new BlogArticlePage(driver);
            case "third":
                clickBlogPost(2);
                return new BlogArticlePage(driver);
            default:
                System.out.println("No menu item selected");
                clickBlogPost(0);
                return new BlogArticlePage(driver);
        }


    }
    public class SearchBox {

        private WebDriver driver;
        private By searchInputFieldMainMenu = By.cssSelector(".search-area .hs-search-field__input");
        private By closeSearch = By.cssSelector(".search-area .close-search ");

        public SearchBox(WebDriver driver) {
            this.driver = driver;
        }

        //what do we want to know eg is the caption displayed

        public boolean isSearchDisplayed() {
            WebElement element = driver.findElement(searchInputFieldMainMenu);
            return element.isDisplayed();
        }

        public void setSearchTerm(String searchString){
            driver.findElement(searchInputFieldMainMenu).sendKeys(searchString);

        }
        public SearchPage hitSearch() {
            driver.findElement(searchInputFieldMainMenu).sendKeys(Keys.ENTER);
        return new SearchPage(driver);}

    }}


