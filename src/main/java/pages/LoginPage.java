package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class LoginPage  {

    private WebDriver driver;
    private By formUserName = By.id("username");
    private By formPassword = By.id("password");
    private By formLoginButton = By.cssSelector("#login button");
    private By statusAlert = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(formUserName).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(formPassword).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(formLoginButton).click();
    return new SecureAreaPage(driver);
    }

    public String getAlertText(){
        String statusAlertText = driver.findElement(statusAlert).getText();
        return statusAlertText;
    }

    //Initializing the Page Objects
    /**
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }**/
}
