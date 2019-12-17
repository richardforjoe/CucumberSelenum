package cucumber.stepdefs;

import base.BaseTests;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.LoginPage;
import pages.HomePage;
import pages.SecureAreaPage;
import services.Endpoints;
import utils.ServicesUtils;

import static java.lang.String.*;
import static org.testng.Assert.assertTrue;
import static utils.ServicesUtils.HttpMethod.*;
import static io.restassured.path.json.JsonPath.from;


public class LoginStepDefs extends BaseTests {

    // The code in this file is called step definitions and they map to the steps within the feature file above

    private Response response;
    private int accountId;

    HomePage homePage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    

    @When("User navigate to (.*) ")
    public void navigateToPage(String page){
        homePage = new HomePage(driver);
        assertTrue(homePage.getTitle().contains("Welcome to the-internet"),"text is incorrect");

        loginPage = homePage.clickFormAuthentication();




    }

    @Then("User enters (.*) and (.*)")
    public void inputLoginDetails(String username, String password){
        String username1 = System.getProperty("customer.username");
        String password1 = System.getProperty("customer.password");

        loginPage.setUsername(username);
        loginPage.setPassword(password);

        secureAreaPage = loginPage.clickLoginButton();

 }

    @Then("^User should get logged in with Message displayed (.*)")
    public void userLoggedIn(String message){
        assertTrue(secureAreaPage.getAlertText().contains(message),"Alert text is incorrect");

    }

    //Rest assured api example stepdefs - Reuse!!!!
    @Given("a customer has an account")
    public void createNewAccount(){
        String customerId = System.getProperty("customer.id");
        String endpoint = format(Endpoints.CREATE_ACCOUNT, customerId);
        response = ServicesUtils.execute(endpoint, POST);
        accountId = from(response.asString()).get("id");
    }

    @And("^the account balance is (.*) dollars$")
    public void setAccountBalance(float desiredBalance) {
        float currentBalance = getCurrentBalance();
        if(desiredBalance != currentBalance){
            deposit(desiredBalance - currentBalance);
        }
    }

    @When("the customer withdraws (.*) dollars")
    public void withdraw(double withdrawAmount){
        String endpoint = format(Endpoints.WITHDRAW, accountId, withdrawAmount);
        response = ServicesUtils.execute(endpoint, POST);
    }

    @Then("the account balance should be (.*) dollars")
    public void verifyBalance(float balance){
        Assert.assertEquals(balance, getCurrentBalance(), 0.0f);
    }

    @Given("User is on Home Page")
    public void loadHomePage(){
        BaseTests.setUp();
        // wait for script to load - > driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

    }

    private float getCurrentBalance(){
        String endpoint = format(Endpoints.GET_ACCOUNT, accountId);
        response = ServicesUtils.execute(endpoint, GET);
        return from(response.asString()).get("balance");
    }

    private void deposit(float amount){
        ServicesUtils.execute(format(Endpoints.DEPOSIT, accountId, amount), POST);
    }

}
