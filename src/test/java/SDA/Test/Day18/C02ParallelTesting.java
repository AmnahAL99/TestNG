package SDA.Test.Day18;

import SDA.Utilities.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C02ParallelTesting extends TestBase {
    @Test
    public void test01(){
        new ChromeDriver().get("https://clarusway.com");

    }    @Test
    public void test02(){
        new ChromeDriver().get("https://ebay.com");

    }
    @Test
    public void test03(){
        driver.get("https://linkedin.com");
    } @Test
    public void test04(){
        driver.get("https://google.com");
    }

}
