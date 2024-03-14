package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    // Define element locators as class variables
    private By searchBoxLocator = By.id("searchInput");
    private By bodyTextLocator = By.cssSelector("body");

    @Test
    public void testSearch() {
        // Navigate to Wikipedia
        driver.get("https://www.wikipedia.org");

        // Use the locator to find the search input field by its ID and enter the search terms
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys("Java Selenium" + Keys.ENTER);

        // Check if the page text contains the search terms
        String pageText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue(pageText.contains("Java") || pageText.contains("Selenium"), "Search result does not contain the searched words.");
    }
}
