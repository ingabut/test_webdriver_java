package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By link_nested_frames = By.xpath(String.format(linkXpath_Format,"Nested Frames"));

    public FramesPage(WebDriver driver) {
        this.driver = driver;

    }
    public NestedFramesPage clickNestedFrames() {
        driver.findElement(link_nested_frames).click();
        return new NestedFramesPage(driver);
    }
}
