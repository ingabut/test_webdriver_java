package tests.hover;

import tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class HoverTests extends BaseTests {
    public void testHoverUser1() {
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        System.out.println("Title: "+caption.getTitle());
        System.out.println("Link: "+caption.getLink());
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
