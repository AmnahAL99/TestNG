package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/* ******************************************
Open the site: https://www.amazon.com/
Do it with DataProvider for
Java
JavaScript
Phyton
****************************************** */

public class AmazonSiteOpenerDP extends TestBase {
    @DataProvider(name = "browserProvider")
    public Object[][] browserTypeProvider() {
        return new Object[][]{
                {"Chrome"},
                {"Firefox"}
        };
    }

    @Test(dataProvider = "browserProvider")
    public void openAmazonSite(String browserType) {
        if (browserType.equals("Chrome")) {

            driver = new ChromeDriver();
        } else if (browserType.equals("Firefox")) {

            driver = new FirefoxDriver();
        }

        driver.get("https://www.amazon.sa/");
    }
 
}
/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="MyTestSuite" parallel="methods" thread-count="5">
    <test name="MyTest">
        <classes>
            <class name="com.example.tests.MyTestClass1"/>
            <class name="com.example.tests.MyTestClass2"/>
        </classes>
    </test>
</suite>

 */