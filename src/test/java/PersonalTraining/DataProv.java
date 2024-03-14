package PersonalTraining;

import SDA.Utilities.DataProviderUtils;
import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProv extends TestBase {

    // Define element locators as class variables
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By submitButtonLocator = By.cssSelector("input[type='submit']");
    private By bodyTextLocator = By.tagName("body");

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviderUtils.class)
    public void testLoginForm(String username, String password) {
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        // Use the locator variables to find elements
        WebElement usernameField = driver.findElement(usernameLocator);
        WebElement passwordField = driver.findElement(passwordLocator);
        WebElement submitButton = driver.findElement(submitButtonLocator);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        // Example verification: Check if redirected to a specific page or content appears
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue(bodyText.contains("Processed Form Details"), "Form submission did not proceed as expected with username: " + username + " and password: " + password);
    }
}
