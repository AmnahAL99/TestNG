package MyPractice.Task1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    private long startTime;

    @Override
    public void onTestStart(ITestResult result) {
        startTime = System.currentTimeMillis();
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Test Passed: " + result.getName() + " in " + executionTime + " ms");
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("the moment test execution ended..");
        System.out.println("-------------------");
        System.out.println("Start time : " +context.getEndDate());

    }

// to takeScreenshot in Desktop
//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("Test Failed: " + result.getName());
//        takeScreenshotAndOpen(result);
//    }

//    private void takeScreenshotAndOpen(ITestResult result) {
//        WebDriver driver = FormTest.driver;
//        if (driver != null) {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String screenshotName = result.getName() + "-screenshot.png";
//            File destFile = new File(screenshotName);
//            try {
//                FileUtils.copyFile(scrFile, destFile);
//                System.out.println("Screenshot taken for failed test: " + result.getName());
//                openScreenshot(destFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void openScreenshot(File file) {
//        if (Desktop.isDesktopSupported()) {
//            try {
//                Desktop.getDesktop().open(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Desktop is not supported, unable to open screenshot.");
//        }
//    }


    @Override
    public void onTestFailure(ITestResult result) {
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Test Failed: " + result.getName() + " in " + executionTime + " ms");
        takeScreenshot(result);
    }

    private void takeScreenshot(ITestResult result) {
        // Accessing the static driver directly
        WebDriver driver = FormTest.driver;
        if (driver != null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(result.getName() + "-screenshot.png"));
                System.out.println("Screenshot taken for failed test: " + result.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Implement other methods as needed (onTestSkipped, onStart, onFinish, etc.)
    }
}


