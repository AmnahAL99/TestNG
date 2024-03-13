package SDA.Test.HW.Day15;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task2 extends TestBase {
    /* ******************************************************
    Test Case2: Negative Username Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username incorrectUser into Username field.
    Type password Password123 into Password field.
    Click Submit button.
    Verify error message is displayed.
    Verify error message text is Your username is invalid!
****************************************************** */
    @Test
    public void negativeUsernameTest() {
        // Navigate to the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type "incorrectUser" into the Username field
        driver.findElement(By.id("username")).sendKeys("incorrectUser");

        // Type "Password123" into the Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click the Submit button
        driver.findElement(By.id("submit")).click();

        // Initialize SoftAssert
        SoftAssert softAssert = new SoftAssert();

        // Verify error message is displayed
        boolean isErrorMessageDisplayed = driver.findElement(By.id("error")).isDisplayed();
        softAssert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed.");

        // Verify error message text is "Your username is invalid!"
        String errorMessageText = driver.findElement(By.id("error")).getText();
        softAssert.assertEquals(errorMessageText, "Your username is invalid!", "Error message text is incorrect.");

        // Assert all
        softAssert.assertAll();
    }

}
