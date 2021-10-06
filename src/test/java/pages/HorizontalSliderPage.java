package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderNumber = By.id("range");
    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterArrows(int times) {
        for (int i=0;i<times;i++){
            System.out.println(driver.findElement(By.className("sliderContainer")).getText());
            driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_RIGHT);

        }
    }
    public String getSliderNumber() {
        return driver.findElement(sliderNumber).getText();
    }
}
