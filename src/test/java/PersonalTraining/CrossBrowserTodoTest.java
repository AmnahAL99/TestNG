package PersonalTraining;

import SDA.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class CrossBrowserTodoTest extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){

            driver = new FirefoxDriver();
        } else{
            throw new Exception("Browser not supported");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://crossbrowsertesting.github.io/todo-app.html");
    }
    @Test
    public void testTodoApp() {
        // Use explicit wait to ensure elements are clickable before clicking
        wait.until(ExpectedConditions.elementToBeClickable(By.name("todo-4"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("todo-5"))).click();
        // Check the items have been clicked by waiting for their 'completed' status
        List<WebElement> checkedItems = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("li[class='ng-scope completed']"), 2));
        Assert.assertEquals(checkedItems.size(), 2, "Not all items were checked");
        // Archive and verify the list size changes
        driver.findElement(By.id("archive")).click();
        List<WebElement> todosAfterArchive = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("li.ng-scope"), 3));
        Assert.assertTrue(todosAfterArchive.size() == 4, "The list size after archiving is incorrect");
    }
    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

