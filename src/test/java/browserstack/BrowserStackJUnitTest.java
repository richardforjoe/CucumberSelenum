package browserstack;


import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parallelized.class)
public class BrowserStackJUnitTest {
    public WebDriver driver;


    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();


        String username = System.getProperty("BROWSERSTACK_USERNAME");
        String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY");

        capabilities.setCapability("browser", "Chrome");
        capabilities.setCapability("browser_version", "62.0");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("resolution", "1024x768");


        driver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+System.getProperty("server")+"/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
