package SDA.Test.Day18;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04ParallelTestDataProvider  {
    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider = "invalidCredentials" )
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(userNameFiled).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);

        Assert.assertTrue(invalidText.isDisplayed());


    }

    @DataProvider(name = "invalidCredentials" , parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"adm", "admin23*"},
                {"dmin", "admin123"},
        };
    }

}
