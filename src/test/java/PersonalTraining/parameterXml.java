package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterXml extends TestBase {
    // Define element locators as class variables
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By submitButtonLocator = By.cssSelector("input[type='submit']");
    private By bodyTextLocator = By.tagName("body");

    @Test
    @Parameters({"usernameField", "passwordField"})
    public void testLoginForm(String usernameField, String passwordField) {
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        // Use the locator variables to find and interact with elements
        driver.findElement(usernameLocator).sendKeys(usernameField);
        driver.findElement(passwordLocator).sendKeys(passwordField);
        WebElement submitButton = driver.findElement(submitButtonLocator);

        submitButton.click();

        // Example verification: Check if redirected to a specific page or content appears
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue(bodyText.contains("Processed Form Details"), "Form submission did not proceed as expected.");
    }
}
















/*
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
    <test name="Test with Parameters">
        <parameter name="usernameField" value="admin"/>
        <parameter name="passwordField" value="password123"/>
        <classes>
            <class name="PersonalTraining.parameterXml"/>
        </classes>
    </test>
</suite>
 */