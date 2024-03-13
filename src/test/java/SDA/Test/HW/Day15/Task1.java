package SDA.Test.HW.Day15;
import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
public class Task1  extends TestBase {
    /* *************************************************
Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
 **************************************************/

    @Test
    public void hardAssertionTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Input username
        driver.findElement(By.id("username")).sendKeys("student");

        // Input password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click the Submit button
        driver.findElement(By.id("submit")).click();

        // Verify the new page URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"), "URL does not contain the expected text.");

        // Verify the new page contains expected text
        WebElement successMessage = driver.findElement(By.cssSelector("body"));
        String bodyText = successMessage.getText();
        Assert.assertTrue(bodyText.contains("Congratulations") || bodyText.contains("successfully logged in"), "Page does not contain expected text.");

        // Verify the Log out button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed.");

    }

    @Test
    public void softAssertionTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Input username
        driver.findElement(By.id("username")).sendKeys("student");

        // Input password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click the Submit button
        driver.findElement(By.id("submit")).click();

        // Create a SoftAssert instance
        SoftAssert softAssert = new SoftAssert();

        // Verify the new page URL
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"), "URL does not contain the expected text.");

        // Verify the new page contains expected text
        WebElement successMessage = driver.findElement(By.cssSelector("body"));
        String bodyText = successMessage.getText();
        softAssert.assertTrue(bodyText.contains("Congratulations") || bodyText.contains("successfully logged in"), "Page does not contain expected text.");

        // Verify the Log out button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        softAssert.assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed.");

        // Execute all soft asserts
        softAssert.assertAll();
    }

}


