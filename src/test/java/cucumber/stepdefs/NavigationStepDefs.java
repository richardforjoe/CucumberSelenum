package cucumber.stepdefs;

import base.BaseTests;
import cucumber.api.java.en.*;
import pages.BlogPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;
import static io.restassured.path.json.JsonPath.from;


public class NavigationStepDefs extends BaseTests {

    // The code in this file is called step definitions and they map to the steps within the feature file above


    HomePage homePage;
    BlogPage blogPage;



    @Given("^I am on the Home page$")
    public void loadHomePage() {
        System.out.println("I am on the Home page...");
        // Write code here that turns the phrase above into concrete actions
        BaseTests.setUp();
        BaseTests.goHome();
        homePage = new HomePage(driver); //Instantiate home page after launching browser
        System.out.println("I am clicking the cookie banner...");
        homePage.clickCookieBanner();
        assertTrue(homePage.getTitle().contains("We use technology to give businesses "),"text is incorrect");




        //assertTrue(homePage.getTitle().contains("Welcome to the-internet"),"text is incorrect");

    }

    @When("^I click the Blogs page link$")
    public void clickBlogsPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am clicking on the blog menu...");
        blogPage = homePage.clickBlogMenu();
            }

    @When("^I scroll to the Blog section$")
    public void scrollBlogsSection() {
        // Write code here that turns the phrase above into concrete actions

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

    @When("^i click first blog$")
        public void clickFirstBlogs() {
        // Write code here that turns the phrase above into concrete actions

    };

    @Then("^I am taken to the Blogs article page$")
        public void iAmOnArticlePage() {
        // Write code here that turns the phrase above into concrete actions


    };

}




