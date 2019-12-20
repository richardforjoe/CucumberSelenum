package cucumber;

import base.BaseTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//runner file

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"cucumber.stepdefs"},
        features = {"src/test/java/cucumber/features"},
        tags = {})

public class CucumberTestOptions {

    @BeforeClass
    public static void setUp(){

    }

    @AfterClass
    public static void tearDown(){
        BaseTests.tearDown();
    }
}