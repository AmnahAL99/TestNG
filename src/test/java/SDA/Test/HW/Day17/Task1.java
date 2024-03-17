package SDA.Test.HW.Day17;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/* ********************************************************************
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: clarusway@gmail.com
Password: 123456789
Using the Search function do it with Data Provider for Mac, iPad and Samsung.
******************************************************************** */

public class Task1 extends TestBase {

    // Define element locators
    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");
    private By searchBox = By.name("search");

    public void login(String email, String password) {
        // Input Email
        driver.findElement(emailInput).sendKeys(email);
        // Input Password
        driver.findElement(passwordInput).sendKeys(password);
        // Click Login Button
        driver.findElement(loginButton).click();
    }

    @DataProvider(name = "searchTermsProvider")
    public Object[][] searchTermsProvider() {
        return new Object[][] {
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "searchTermsProvider")
    public void testSearch(String searchTerm) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        login("clarusway@gmail.com", "123456789");
        WebElement searchField = driver.findElement(searchBox);
        searchField.clear();
        searchField.sendKeys(searchTerm);
        // Attempt to find the search button and click it if available
        try {
            WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit'][class*='search']")); // Update this selector as per your website's markup
            searchButton.click();
        } catch (NoSuchElementException e) {
            // If the search button is not found, send ENTER key as a fallback
            searchField.sendKeys(Keys.ENTER);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("search"), "Search results page not displayed.");
    }

}


