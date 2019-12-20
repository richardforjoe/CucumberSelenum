package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    //private WebDriver driver;// Create webdriver object
    protected static EventFiringWebDriver driver;
    //protected static EventFiringWebDriver browserstack_driver;
    protected static HomePage homePage;


    @BeforeClass
    public static void setUp() { // Setup method - Selenium needs to know where executable file is - use System.setProperty

        utils.BaseClass.loadTestProperties("test");

        //BrowserStack
        /**FirefoxDriver browserstack_driver = new FirefoxDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();


        String username = System.getProperty("BROWSERSTACK_USERNAME");
        String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY");

        capabilities.setCapability("browser", "Chrome");
        capabilities.setCapability("browser_version", "62.0");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("resolution", "1024x768");


        browserstack_driver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+System.getProperty("server")+"/wd/hub"), DesiredCapabilities.firefox());
        **/
        //String chromeresource = System.getProperty("webdriver.chrome.driver");

        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //driver = new ChromeDriver(); //EdgeDriver, FirefoxDriver, InternetExplorerDriver etc
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        //implement class to listen
        driver.register(new EventReporter());
        goHome();
        setCookie();
        // wait for script to load - > driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);
        driver.manage().window().maximize();//driver.manage.maximize() /fullscreen()
        homePage = new HomePage(driver); //Instantiate home page after launching browser
    }

    @BeforeMethod
    public static void goHome(){
        driver.get(System.getProperty("app.url")); // get url
        //browserstack_driver.get(System.getProperty("app.url"));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
        //browserstack_driver.quit();
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

    private static ChromeOptions getChromeOptions(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("disable-infobars");
        chromeoptions.setHeadless(false);
    return chromeoptions;}

    private static void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }



}

