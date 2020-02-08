package base.navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BlogPage;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    @Test
    public void testSuccessfullNavigateToBlog(){
        BlogPage blogPage = homePage.clickBlogMenu();


  //      assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),"Alert text is incorrect");
//        assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!\n" +
//                "×","You have successfully logged in");
    }}


