package SDA.Test.HW.Day17;
import SDA.Utilities.ParameterBrowserTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task2 extends ParameterBrowserTestBase {
    /* ********************************************************
     Assert using soft Asser
Go to URL: http://crossbrowsertesting.github.io/todo-app.html
Checking Box todo-4 and Checking Box todo-5
If both clicks worked, then the following List should be have length 2.
Assert that this is correct
Assert that the todo we added is present in the list
Archiving old todos
If our archive link worked, then the following list should have length 4.
Assert that this is true as well using soft Assert
Doing Cross Browser Testing.
******************************************************** */
    // Locators
    private By todo4 = By.name("todo-4");
    private By todo5 = By.name("todo-5");
    private By Count = By.xpath("//ul[@class='list-unstyled']/li[not(@class='ng-hide')]");
    private By archive = By.xpath("//a[@ng-click='todoList.archive()']");
    private By addTodo = By.id("todotext");
    @Test
    public void testTodoApp() {

        driver.get("http://crossbrowsertesting.github.io/todo-app.html");
        driver.findElement(todo4).click();
        driver.findElement(todo5).click();
        SoftAssert sa = new SoftAssert();
        int Todos = driver.findElements(Count).size();
        sa.assertEquals(Todos, 5, "Expected 5 items in the list after checking two todos.");
        // Archive completed todos
        driver.findElement(archive).click();

        driver.findElement(addTodo).sendKeys("Task 2 by Cross Browser chrome and firefox ", Keys.ENTER);

        Todos = driver.findElements(Count).size();
        sa.assertEquals(Todos, 4, "Expected 4 items in the list after archiving and adding a new todo.");

        sa.assertAll();
    }
}

/*
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
 */