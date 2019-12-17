package utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;

    public static Properties props;

    public static void loadTestProperties(String property){
        props = System.getProperties();
        try {
            props.load(
                    new FileInputStream(new File("resources/"+property+".properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


}
