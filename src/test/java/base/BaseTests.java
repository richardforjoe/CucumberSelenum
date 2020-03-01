package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {

    //private WebDriver driver;// Create webdriver object
    protected static EventFiringWebDriver driver;
    protected static HomePage homePage;


    @BeforeClass
    public static void setUp() { // Setup method - Selenium needs to know where executable file is - use System.setProperty
        System.out.println("Into the setup method of BaseTests @Before Class...");
        releaseResources(driver);
        utils.BaseClass.loadTestProperties("test");

        WebDriverManager.chromedriver().setup();

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        //implement class to listen
        driver.register(new EventReporter());
        //goHome();
        //homePage = new HomePage(driver); //Instantiate home page after launching browser



    }

    @BeforeMethod
    public static void goHome(){
        System.out.println("Launching the page url...");
        driver.get(System.getProperty("app.url")); // get url
        driver.manage().window().maximize();
        //*[@id="hs_menu_wrapper_module_14668741230142"]/ul/li[1]/a/text()
        //driver.manage().window().setSize(new Dimension(375,812));
        //System.out.println(driver.getTitle());
        //browserstack_driver.get(System.getProperty("app.url"));
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Into the tearDown method of BaseTest @AfterClass...");
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
        System.out.println("Into the @AfterMethod of BaseTest...");
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
        chromeoptions.addArguments("start-maximized");
        chromeoptions.setHeadless(false);

        //https://www.guru99.com/chrome-options-desiredcapabilities.html

    return chromeoptions;}

    public static void releaseResources(WebDriver driver) {
        System.out.println("Releasing resources now.....");
        if (null != driver) {
            driver.close();
            driver.quit(); //CLOSES ALL THE OPEN BROWSER SESSIONS LEAVING OTHER STEP EXECUTIONS INCOMPLETE
        }
    }




}

