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
    public void testTodoApp1() {
        SoftAssert sa = new SoftAssert();
        driver.get("http://crossbrowsertesting.github.io/todo-app.html");

        // Initial list size check
        int initialTodos = driver.findElements(Count).size();
        System.out.println("Initial Todos: " + initialTodos); // For debug purposes

        // Checking boxes for todo-4 and todo-5
        driver.findElement(todo4).click();
        driver.findElement(todo5).click();

        // Size after checking specific todos
        int checkedTodos = driver.findElements(Count).size();
        System.out.println("Todos after checking items: " + checkedTodos); // For debug purposes
        // Assert that the size matches expected after checking boxes
        // Note: Assuming checking does not hide them immediately
        sa.assertEquals(checkedTodos, initialTodos, "The size should remain the same after checking items since they are not hidden or removed.");

        // Adding a new todo item
        driver.findElement(addTodo).sendKeys("Task 2 by Cross Browser chrome and firefox ", Keys.ENTER);
        // Archive completed todos
        driver.findElement(archive).click();

        // Size after archiving and adding a new todo
        int finalTodos = driver.findElements(Count).size();
        System.out.println("Final Todos after archiving and adding a new one: " + finalTodos); // For debug purposes
        // Asserting the list's size after archiving and adding a new todo
        // Adjust the expected number according to what's logically expected after these operations
        sa.assertEquals(finalTodos, initialTodos - 2 + 1, "Expected one less item in the list after archiving two and adding one new todo.");

        sa.assertAll();
    }
}

/*
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
 */