package SDA.Test.HW.Day16;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task1 extends TestBase {

    @Test
    @Parameters({"searchWord1"})
    public void testSearch1(String searchWord1) {
        driver.get("https://www.google.com");

        // Use By locators to identify elements
        By searchBoxLocator = By.name("q");

        // Now find the element using the locator when needed
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(searchWord1);
        searchBox.submit();

        By bodyLocator = By.tagName("body");
        String bodyText = driver.findElement(bodyLocator).getText();
        Assert.assertTrue(bodyText.contains(searchWord1));
    }

    @Test
    @Parameters({"searchWord2"})
    public void testSearch2(String searchWord2) {
        driver.get("https://www.google.com");

        // Use By locators to identify elements
        By searchBoxLocator = By.name("q");

        // Now find the element using the locator when needed
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(searchWord2);
        searchBox.submit();

        By bodyLocator = By.tagName("body");
        String bodyText = driver.findElement(bodyLocator).getText();
        Assert.assertTrue(bodyText.contains(searchWord2));
    }}


