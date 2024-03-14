package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    // Define element locators as class variables
    private By usernameLocator = By.xpath("//input[@placeholder='Username']");
    private By passwordLocator = By.xpath("//input[@placeholder='Password']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By errorMessageLocator = By.xpath("//div[@role='alert']");

    @DataProvider(name = "invalidCredentialsProvider")
    public Object[][] invalidCredentialsProvider() {
        return new Object[][] {
                {"admin", "wrongPassword"},
                {"wrongUsername", "admin123"},
                {"123", "321"} // Testing with empty username and password
                // Add more invalid username-password combinations as needed
        };
    }

    @Test(dataProvider = "invalidCredentialsProvider")
    public void testInvalidLogin(String username, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Use the locators
        WebElement usernameField = driver.findElement(usernameLocator);
        WebElement passwordField = driver.findElement(passwordLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement loginErrorMessage = driver.findElement(errorMessageLocator);
        String errorMessage = loginErrorMessage.getText();
        Assert.assertEquals(errorMessage, "Invalid credentials", "The error message did not match the expected text.");
    }
}
