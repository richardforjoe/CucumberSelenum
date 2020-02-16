package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BlogPage;
import pages.IntegrationsPage;
import pages.SearchPage;

import java.util.List;

public class MenuNavigation {

    private WebDriver driver;
    private By menuNavigation = By.cssSelector("li.hs-menu-item.hs-menu-depth-1");
    private By searchButtonMainMenu = By.cssSelector("li .search-trigger ");
    private By subMenuNavigation = By.cssSelector("ul.hs-menu-children-wrapper");
    private WebElement subMenu;
    private By subMenuHoover = By.cssSelector("li.hs-item-has-children");
    private By hooverlink = By.cssSelector("ul.hs-menu-children-wrapper a");

    public MenuNavigation(WebDriver driver){
        this.driver = driver;
    }
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public boolean isSubMenuDisplayed(){
        return subMenu.isDisplayed();
    }

    public String getSubMenuTitle(int index){
        return subMenu.findElements(subMenuHoover).get(index).getText();
    }

    public String getSubMenuLink(int index){
        return subMenu.findElements(hooverlink).get(index).getAttribute("href");
    }

    public String getSubMenuLinkText(int index){
        return subMenu.findElements(hooverlink).get(index).getText();
    }

    public void hoverOverMainMenu(String menu,int index){

        WebElement menuItems;
        Actions actions = new Actions(driver); //contains advanced interactions

        switch (menu) {
            case "Services":
                menuItems = driver.findElements(menuNavigation).get(0);
                actions.moveToElement(menuItems).perform();
                break;
            case "Business solutions":
                menuItems = driver.findElements(menuNavigation).get(1);
                actions.moveToElement(menuItems).perform();
                break;
            case "nsights":
                menuItems = driver.findElements(menuNavigation).get(3);
                actions.moveToElement(menuItems).perform();
                break;
            default:
                System.out.println("No menu item selected");
                break;
        }




        WebElement subMenu = driver.findElements(subMenuNavigation).get(index - 1);
        actions.moveToElement(subMenu).perform(); //Move mouse to element, hoover
        actions.moveToElement(subMenu).click();

    }

    public IntegrationsPage hoverOverSubMenu(int index) {

        List<WebElement> menuItems = driver.findElements(subMenuNavigation);
        Actions actions = new Actions(driver); //contains advanced interactions

         actions.moveToElement(menuItems.get(index)).perform();
         actions.moveToElement(menuItems.get(index)).click();

    return new IntegrationsPage(driver);}

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
