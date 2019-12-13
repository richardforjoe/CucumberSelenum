package base.hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {


    @Test
    public void testHoverUser1(){
        HoversPage hoverPage = homePage.clickHover();
        var caption = hoverPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1","Caption title is incorrect");
        assertEquals(caption.getLinkText(),"View profile","Link text is incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"Link is incorrect");

    }


}
