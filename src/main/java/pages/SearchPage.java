package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }


    private By pageTitle = By.tagName("h1");
    private By searchResultsReturned = By.cssSelector(".hs-search-results .hs-search-results__result-count");
    private By searchresults = By.cssSelector(".hs-search-results .hs-search-results__listing li");
    private By searchresultType = By.cssSelector(".hs-search-results__type");
    private By searchresultTitle = By.cssSelector(".hs-search-results__title");
    private By searchresultDescription = By.cssSelector(".hs-search-results__description");

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public String getSearchResultAttribute(int searchResultNumber,String  attribute) {
        List<WebElement> searchResults = driver.findElements(searchresults);
        System.out.println(searchResults.size());

        switch (attribute) {
            case "Type":
                return searchResults.get(searchResultNumber).findElement(searchresultType).getAttribute("class").split(" ")[1];
            case "Title":
                return searchResults.get(searchResultNumber).findElement(searchresultTitle).getText();
            case "Description":
                return searchResults.get(searchResultNumber).findElement(searchresultDescription).getText();
            case "Total":
                return driver.findElement(searchResultsReturned).getText().split(" ")[3];
            default:
                System.out.println("Invalid");
                return driver.findElement(searchResultsReturned).getText();
        }}

    public Boolean isSearchResultsContainingSearchTerm(String searchTerm) {
        List<WebElement> searchResults = driver.findElements(searchresults);
        Integer totalResults = searchResults.size();
        Integer containSearchTerm = 0;

                for (int i = 0; i < totalResults; i++){
                    if (searchResults.get(i).findElement(searchresultTitle).getText().toLowerCase().contains(searchTerm))
                    {
                        ++containSearchTerm;
                    } else if (searchResults.get(i).findElement(searchresultDescription).getText().toLowerCase().contains(searchTerm)){
                        ++containSearchTerm;
                }


        }
        if(containSearchTerm == totalResults){
            return true;
        } else {
            return false;
        }
    }
}

