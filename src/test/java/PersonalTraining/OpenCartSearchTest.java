package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenCartSearchTest extends TestBase {

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
        searchField.submit();

        // Add your assertions here
        // Example: Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(searchTerm), "Search term not found in results.");

        // Assert that search results page is displayed
        Assert.assertTrue(driver.getCurrentUrl().contains("search"), "Search results page not displayed.");
    }

}

