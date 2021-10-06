package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String leftFrame = "frame-left";
    private String topFrame = "frame-top";
    private String bottomFrame = "frame-bottom";
    private By textArea = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;

    }
    private void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }
    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
    public String getTextFromLeftFrame() {
        switchToFrame(topFrame);
        switchToFrame(leftFrame);
        String text = driver.findElement(textArea).getText();
        switchToParentFrame();
        switchToParentFrame();
        return text;
    }
    public String getTextFromBottomFrame() {
        switchToFrame(bottomFrame);
        String text = driver.findElement(textArea).getText();
        switchToParentFrame();
        return text;
    }
}
