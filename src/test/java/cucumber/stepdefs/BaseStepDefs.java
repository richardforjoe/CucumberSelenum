package cucumber.stepdefs;

import actions.MenuNavigation;
import base.BaseTests;
import cucumber.api.java.en.*;
import pages.*;

import static org.testng.Assert.assertTrue;
import static io.restassured.path.json.JsonPath.from;


public class BaseStepDefs extends BaseTests {

    // The code in this file is called step definitions and they map to the steps within the feature file above


    HomePage homePage;
    BlogPage blogPage;
    BlogArticlePage blogArticlePage;
    SearchPage searchPage;
    MenuNavigation menuNavigation;
    IntegrationsPage integrationsPage;



    @Given("^I am on the Home page$")
    public void loadHomePage() {
        System.out.println("I am on the Home page...");
        // Write code here that turns the phrase above into concrete actions
        BaseTests.setUp();
        BaseTests.goHome();
        homePage = new HomePage(driver); //Instantiate home page after launching browser
        menuNavigation = new MenuNavigation(driver); //Instantiate menu navigation after launching browser
        System.out.println("I am clicking the cookie banner...");
        homePage.clickCookieBanner();
        assertTrue(homePage.getTitle().contains("We use technology to give businesses "),"text is incorrect");

        //menuNavigation.hoverOverSubMenu(1);



        //assertTrue(homePage.getTitle().contains("Welcome to the-internet"),"text is incorrect");

    }

    @When("^I click the Blogs page link$")
    public void clickBlogsPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am clicking on the blog menu...");
        blogPage = menuNavigation.clickBlogMenu();
            }

    @When("^I click the Integrations page link$")
    public void clickIntegrationsPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am clicking on the Services/ Integration link menu...");
         integrationsPage = menuNavigation.hoverOverSubMenu(0);
    }

    @When("^I scroll to the Blog section$")
    public void scrollBlogsSection() {
        // Write code here that turns the phrase above into concrete actions
        homePage.scrollToSection();
    }

    @Then("^I am taken to the Blogs page$")
    public void BlogsPage() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(blogPage.getTitle().contains("Blog"),"text is incorrect");

    };

    @Then("^a list of Blogs are shown$")
    public void listofBlogs() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(blogPage.getTotalBlogDisplayed() > 0,"There are no blogs listed");

    };


    @When("^I search for (.*) via search menu$")
    public void searchForTerm(String searchTerm) {
        // Write code here that turns the phrase above into concrete actions
        searchPage = menuNavigation.searchForATerm(searchTerm);
    };

    @Then("^I am shown search results containing (.*) on the search results page$")
    public void displaySearchResult(String searchTerm) {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = searchPage.getPageTitle();
        Integer searchResultTotal = Integer.parseInt(searchPage.getSearchResultAttribute(0,"Total"));
/*        String searchResultType = searchPage.getSearchResultAttribute(0,"Type");
        String searchResultTitle = searchPage.getSearchResultAttribute(0,"Title");
        String searchResultDescription = searchPage.getSearchResultAttribute(0,"Description");
*/
        assertTrue(pageTitle.equals("Search Results"),"The wrong page was displayed");
        assertTrue(searchResultTotal > 0,"No results are returned");
        assertTrue(searchPage.isSearchResultsContainingSearchTerm(searchTerm),"The results do not match the search term");

    };

    @When("^i click (.*) blog$")
        public void clickFirstBlogs(String blogNumber) {
        // Write code here that turns the phrase above into concrete actions
        blogArticlePage = homePage.clickBlog(blogNumber);
    };


    @Then("^I am taken to the Blogs article page$")
        public void iAmOnArticlePage() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(blogArticlePage.getBlogPostArticleTitle().equals(homePage.getCurrentblogPostTitle()),"The wrong blog was displayed");

    };

}




