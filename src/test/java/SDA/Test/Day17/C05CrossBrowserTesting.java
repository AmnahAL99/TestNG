package SDA.Test.Day17;

import SDA.Utilities.ParameterBrowserTestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C05CrossBrowserTesting extends ParameterBrowserTestBase {


    @Test
    public void test1(){driver.get("https://www.clarusway.com./");}

    @Test
    public void test2(){driver.get("https://www.ebay.com/");}

    @Test
    public void test3(){driver.get("https://www.linkedin.com/");}

    @Test
    public void test4(){driver.get("https://www.clarusway.com./");}
}
