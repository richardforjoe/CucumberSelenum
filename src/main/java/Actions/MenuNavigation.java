package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BlogPage;
import pages.SearchPage;

import java.util.List;

public class MenuNavigation {

    private WebDriver driver;
    private By menuNavigation = By.cssSelector("li.hs-menu-item.hs-menu-depth-1");
    private By searchButtonMainMenu = By.cssSelector("li .search-trigger ");

    public MenuNavigation(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage searchForATerm(String searchString){
        selectMainMenu("Search");
        MenuNavigation.SearchBox searchBox = new MenuNavigation.SearchBox(driver);
        searchBox.setSearchTerm(searchString);

        return searchBox.hitSearch();}

    public BlogPage clickBlogMenu(){
        selectMainMenu("Blog");
        return new BlogPage(driver);}

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
