package base.alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("/Users/rforjoe/Documents/GitHub_Repo/SeleniumProject/resources/chromedriver");
        assertEquals(fileUploadPage.getUploadedFilesConfirmation(),"chromedriver","Upload file was unsuccessfull");
    }
}
