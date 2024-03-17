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
