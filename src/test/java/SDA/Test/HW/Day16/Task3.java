package SDA.Test.HW.Day16;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3 extends TestBase {

    // Data Provider Method
    @DataProvider(name = "loginDataProvider")
    public Object[][] provideLoginData() {
        return new Object[][] {
                {"incorrectUser", "correctPass"},
                {"anotherWrongUser", "anotherRightPass"}
        };
    }

    // Test Method Linked to Data Provider
    @Test(dataProvider = "loginDataProvider")
    public void negativeScenario(String negativeUsername, String positivePassword) {
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By error = By.id("error");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys(negativeUsername);
        passwordInput.sendKeys(positivePassword);

        submitButton.click();

        SoftAssert sa = new SoftAssert();

        WebElement errorMessage  = driver.findElement(error);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertAll();
    }
}
