package tests.slider;

import tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider4() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.enterArrows(8); //step 0,5
        assertEquals(horizontalSliderPage.getSliderNumber(),"4");
    }

}
