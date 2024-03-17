package MyPractice.Task3;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class BasicTest5  extends TestBase {

    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
    public void TestLogin(String userName, String password) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Wait until the URL changes to the dashboard or expected page after login
        boolean urlChanged = wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

        // Assert based on URL
        Assert.assertTrue(urlChanged, "Did not navigate to the expected URL.");        Thread.sleep(5000);
        driver.quit();
    }

}
