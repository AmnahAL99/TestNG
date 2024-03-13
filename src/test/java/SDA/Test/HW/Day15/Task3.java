package SDA.Test.HW.Day15;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3 extends TestBase {
    /* ******************************************
Test Case3: Negative Password Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field.
Type password incorrectPassword into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error message text is Your password is invalid!
****************************************** */
    @Test
    public void negativePasswordTest() {
        // Navigate to the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type "student" into the Username field
        driver.findElement(By.id("username")).sendKeys("student");

        // Type "incorrectPassword" into the Password field
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");

        // Click the Submit button
        driver.findElement(By.id("submit")).click();

        // Initialize SoftAssert
        SoftAssert softAssert = new SoftAssert();

        // Verify error message is displayed
        boolean isErrorMessageDisplayed = driver.findElement(By.id("error")).isDisplayed();
        softAssert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed.");

        // Verify error message text is "Your password is invalid!"
        String errorMessageText = driver.findElement(By.id("error")).getText();
        softAssert.assertEquals(errorMessageText, "Your password is invalid!", "Error message text is incorrect.");

        // Assert all
        softAssert.assertAll();
    }

}
