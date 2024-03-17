package SDA.Test.Day17;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01DataProvider extends TestBase {
       /*
    @DataProvider is a TestNG annotation.
    Therefore, it is used exclusively with TestNG.
    It is used to provide data / obtain a list of data in TestNG.
    It is used for Data Driven Testing (DDT).
    It serves the same purpose as Scenario Outline in Cucumber.
    How to pass data from one method to another using DataProvider?

    Use the dataProvider in the test method and set the description equal to the method name.
    We can provide an alternative name using "name = "alternative name".
    */
       private By searchBox = By.xpath("//input[@id='gh-ac']");

    @DataProvider(name = "searchTermsProvider")
    public Object[][] searchTermsProvider() {
        return new Object[][] {
                {"Java"},
                {"JavaScript"},
                {"Python"}
        };
    }
       @Test(dataProvider = "searchTermsProvider")
       public void testSearch(String searchTerm) {
           driver.get("https://www.ebay.com/");
           WebElement searchField = driver.findElement(searchBox);
           searchField.clear();
           searchField.sendKeys(searchTerm);
           searchField.submit();

       }
}
