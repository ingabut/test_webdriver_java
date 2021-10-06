package tests.frames;

import tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.increaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text frame incorrect");
    }
    @Test
    public void testNestedFrames() {
        String left = "LEFT";
        String bottom = "BOTTOM";
        var framesPage = homePage.clickFramesPage();
        var nestedFramesPage = framesPage.clickNestedFrames();
        assertEquals(nestedFramesPage.getTextFromLeftFrame(), left, "Text in left frame incorrect");
        assertEquals(nestedFramesPage.getTextFromBottomFrame(), bottom, "Text in bottom frame incorrect");
    }
}
