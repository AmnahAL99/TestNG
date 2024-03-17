package MyPractice.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicFormPage {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By commentsField = By.name("comments");
    private By submitButton = By.cssSelector("input[type='submit']");

    public BasicFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setComments(String comments) {
        driver.findElement(commentsField).sendKeys(comments);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

}


