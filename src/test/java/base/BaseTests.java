package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
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

    @AfterMethod //runs after each test run
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        try {
            Files.move(screenshot,new File("resources/screenshots/" + result.getName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
