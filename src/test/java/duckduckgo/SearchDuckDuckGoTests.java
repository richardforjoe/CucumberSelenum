package duckduckgo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DuckDuckGoPages.DuckDuckGoResultsPage;
import pages.DuckDuckGoPages.DuckDuckGoSearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchDuckDuckGoTests {
    private WebDriver driver;

    @BeforeEach
    public void initWebDriver() {

        utils.BaseClass.loadTestProperties("test");
        driver = new ChromeDriver();
    }

    @Test
    public void searchDuckDuckGo() {
        //Load the page
        DuckDuckGoSearchPage searchPage = new DuckDuckGoSearchPage(driver);
        searchPage.loadPage();

        //Enter search phrase
        searchPage.search("giant panda");

        //results page
        DuckDuckGoResultsPage resultsPage = new DuckDuckGoResultsPage(driver);
        List<String> linkTexts = resultsPage.getResultsLinkText("panda");

        //Assert each result cntains the word panda
        for (String text : linkTexts) {
            assertTrue(text.matches("(?i).*panda.*"));
        }
    }

    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}
