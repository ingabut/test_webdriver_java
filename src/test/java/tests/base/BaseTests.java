package tests.base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;


public class BaseTests {
    private EventFiringWebDriver driver;
    //private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
/*
        try {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY,getChromeOptions());
            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
*/
        //uncomment when return back to EventFiringWebDriver
         driver.register(new EventReporter());

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout();
        goHome();
        setCookie();

        /*
        WebElement shiftingLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingLink.click();
        WebElement menuLink = driver.findElement(By.partialLinkText("Menu Element"));
        menuLink.click();
        List<WebElement> links = driver.findElements(By.tagName("li"));
        System.out.println(links.size());
        */
        //driver.manage().window().setSize(new Dimension(375,812));

        //System.out.println(driver.getTitle());

    }
    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            } catch(IOException e) {

            }
        }
        //System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
    }
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
     //   options.setHeadless(true);
        return  options;
    }
    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
    /*
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();

    }
     */
}
