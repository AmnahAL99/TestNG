package MyPractice.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class FormTest02 {
   // public static WebDriver driver;

    @Test
    public void testFormSubmission() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
            driver.findElement(By.name("username")).sendKeys("TestUser");
            driver.findElement(By.name("password")).sendKeys("TestPass");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            String bodyText = driver.findElement(By.tagName("body")).getText();
            Assert.assertTrue(bodyText.contains("Processed Form Details"), "Form submission failed.");
            // Inside testFormSubmission method after navigating to the page

// Select a radio button
        //    driver.findElement(By.cssSelector("input[value='rd1']")).click();

// Check a checkbox
            //driver.findElement(By.name("checkboxes[]")).click();

// Select an option from dropdown
         //   driver.findElement(By.name("dropdown")).sendKeys("dd5");

// Assuming there's a specific assertion for these actions

        } finally {
            driver.quit();
        }
    }

}
