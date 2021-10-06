package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[contains(@title,'Increase indent')]");
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;

    }
    public void clearTextArea() {
        switchToEditEditor();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text) {
        switchToEditEditor();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndention(){
        System.out.println(driver.findElement(increaseIndentButton).getTagName());
        driver.findElement(increaseIndentButton).click();
    }
    public String getTextFromEditor() {
        switchToEditEditor();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    private void switchToEditEditor() {
        driver.switchTo().frame(editorIframeId);
    }
    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}