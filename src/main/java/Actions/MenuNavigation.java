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
    private By searchButtonMainMenu = By.cssSelector("li .search-trigger");
    private By subMenuNavigation = By.cssSelector("ul.hs-menu-children-wrapper a");
    private WebElement subMenu;
    private By subMenuHoover = By.cssSelector("li.hs-item-has-children");

    private String selectedSubMenuLinkText = "";

    public MenuNavigation(WebDriver driver){
        this.driver = driver;
    }
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public boolean isSubMenuDisplayed(int index){
        subMenu = driver.findElements(subMenuNavigation).get(index);
        return subMenu.isDisplayed();
    }

    public String getMainMenuTitle(int index){
        subMenu = driver.findElements(menuNavigation).get(index);
        return subMenu.getText();
    }

    public String getSubMenuLink(int index){
        subMenu = driver.findElements(subMenuNavigation).get(index);
        return subMenu.getAttribute("href");
    }

    public String getSubMenuLinkText(int index){
        subMenu = driver.findElements(subMenuNavigation).get(index);
        return subMenu.getText();
    }

    public void hooverSubMenu(int menuIndex, int subMenuIndex){
        Actions actions = new Actions(driver);
        List<WebElement> menuItems = driver.findElements(menuNavigation);
        List<WebElement> subMenuItems = driver.findElements(subMenuNavigation);

        actions.moveToElement(menuItems.get(menuIndex));
        actions.moveToElement(subMenuItems.get(subMenuIndex));
        actions.perform();
    }


    public IntegrationsPage clickIntegratonsSubMenu() {
        selectMainMenuLink("Integration");
    return new IntegrationsPage(driver);}

    public SearchPage searchForATerm(String searchString){
        selectMainMenuLink("Search");
        MenuNavigation.SearchBox searchBox = new MenuNavigation.SearchBox(driver);
        searchBox.setSearchTerm(searchString);

        return searchBox.hitSearch();}

    public BlogPage clickBlogMenu(){
        selectMainMenuLink("Blog");
        return new BlogPage(driver);}

    private void selectMainMenuLink(String menu){
        Actions actions = new Actions(driver);
        List<WebElement> menuItems = driver.findElements(menuNavigation);
        List<WebElement> subMenuItems = driver.findElements(subMenuNavigation);

        System.out.println(menuItems.size());

        switch (menu) {
            case "Services":
                actions.moveToElement(menuItems.get(0));
                actions.click().build().perform();
                break;
            case "Integration":
                actions.moveToElement(menuItems.get(0));
                actions.moveToElement(subMenuItems.get(0));
                actions.click().build().perform();
                break;
            case "Blog":
                actions.moveToElement(menuItems.get(5));
                actions.click().build().perform();
                break;
            case "Search":
                actions.moveToElement(menuItems.get(6));
                actions.click().build().perform();
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
