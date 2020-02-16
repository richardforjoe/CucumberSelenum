package base.navigation;

import actions.MenuNavigation;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    MenuNavigation menuNavigation;

    @Test
    public void testSuccessfullNavigateToBlog(){
        //BlogPage blogPage = menuNavigation.clickBlogMenu();

        //homePage = new HomePage(driver); //Instantiate home page after launching browser
        menuNavigation = new MenuNavigation(driver); //Instantiate menu navigation after launching browser
        menuNavigation.hooverSubMenu(0,0);
        System.out.println(menuNavigation.isSubMenuDisplayed(0));
        System.out.println(menuNavigation.getSubMenuLink(0));;
        System.out.println(menuNavigation.getSubMenuLinkText(0));;
        menuNavigation.hooverSubMenu(0,1);
        System.out.println(menuNavigation.isSubMenuDisplayed(1));
        System.out.println(menuNavigation.getSubMenuLink(1));;
        System.out.println(menuNavigation.getSubMenuLinkText(1));;
        menuNavigation.hooverSubMenu(0,2);
        menuNavigation.hooverSubMenu(0,3);
        menuNavigation.hooverSubMenu(0,4);
        menuNavigation.hooverSubMenu(1,0);
        menuNavigation.hooverSubMenu(1,1);
        menuNavigation.hooverSubMenu(1,2);
        menuNavigation.hooverSubMenu(3,0);
        menuNavigation.hooverSubMenu(3,1);
        menuNavigation.hooverSubMenu(3,2);
        menuNavigation.hooverSubMenu(3,3);



  //      assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),"Alert text is incorrect");
//        assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!\n" +
//                "×","You have successfully logged in");
    }}


