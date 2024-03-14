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
        WebElement searchBox = driver.findElement(By.name("q"));
        // Combine the search words
        String Search = searchWord1;
        searchBox.sendKeys(Search);
        searchBox.submit();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(searchWord1));

    }

    @Test
    @Parameters({"searchWord2"})
    public void testSearch2(String searchWord2) {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));

        String Search = searchWord2;
        searchBox.sendKeys(Search);
        searchBox.submit();
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(searchWord2));
    }
    }
/* ***********************************************

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
    <test name="Test with Parameters">
        <parameter name="searchWord1" value="Java" />
        <parameter name="searchWord2" value="Selenium" />
        <classes>
            <class name="SDA.Test.HW.Day16.Task1"/>
        </classes>
    </test>
</suite>




 *********************************************** */

