package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.WindowManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;// Create webdriver object
    protected HomePage homePage;


    @BeforeClass
    public void setUp() { // Setup method - Selenium needs to know where executable file is - use System.setProperty
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver(); //EdgeDriver, FirefoxDriver, InternetExplorerDriver etc
        goHome();
        // wait for script to load - > driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);
        driver.manage().window().maximize();//driver.manage.maximize() /fullscreen()
        homePage = new HomePage(driver); //Instantiate home page after launching browser
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/"); // get url
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    //No longer needed
//    public static void main(String[] args) {
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
