package tests.alerts;

import tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Inga\\IdeaProjects\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","Uploaded files incorrect");
    }
}
