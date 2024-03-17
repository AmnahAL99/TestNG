package SDA.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
//    @BeforeMethod
//    @Parameters("browser")
//    public void setUp(String browser) {
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
//        }
//    }

    @AfterMethod
    public void tearDown() {
        // Close the browser and quit the driver session
        if (driver != null) {
            driver.quit();
        }
    }
}

/*
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="CrossBrowserSuite">
    <test name="ChromeTest">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="CrossBrowserTest"/>
        </classes>
    </test>
    <test name="FirefoxTest">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="CrossBrowserTest"/>
        </classes>
    </test>
</suite>

 */