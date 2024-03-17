package MyPractice.Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;


@Listeners(TestListener.class)
public class FormTest {
    private WebDriver driver;
    private BasicFormPage formPage;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        formPage = new BasicFormPage(driver);
    }

    @Test
    public void testFormSubmission() {
        formPage.setUsername("testuser");
        formPage.setPassword("password");
        formPage.setComments("This is a test comment.");
        formPage.submitForm();
//        // Add assertions here to verify the form submission was successful.
        String expectedURL = "https://testpages.eviltester.com/expectedPageAfterSubmission.html"; // Change this to the actual URL
        String actualURL = driver.getCurrentUrl();
       Assert.assertNotEquals(actualURL, expectedURL , "The from  redirect to the expected URL.");
    }

    }




