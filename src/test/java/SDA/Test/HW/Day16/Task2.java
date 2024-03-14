package SDA.Test.HW.Day16;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task2 extends TestBase {
    @Test
    @Parameters({"username", "password"})
    public void softAssertionTest(String username, String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // Input username
        driver.findElement(By.id("username")).sendKeys(username);
        // Input password
        driver.findElement(By.id("password")).sendKeys(password);
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
/* ***********************************************

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite">
    <test name="SuccessfulLoginTest">
        <parameter name="username" value="student" />
        <parameter name="password" value="Password123" />
        <classes>
            <class name="SDA.Test.HW.Day16.Task2" />
        </classes>
    </test>
    <test name="FailedLoginTestIncorrectPassword">
        <parameter name="username" value="student" />
        <parameter name="password" value="wrongPassword" />
        <classes>
        <class name="SDA.Test.HW.Day16.Task2" />
        </classes>
    </test>
    <!-- Add more scenarios here if needed -->
</suite>

 *********************************************** */
