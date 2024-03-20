package SDA.Utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listener implements ITestListener , IRetryAnalyzer , IAnnotationTransformer {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println("Start time : " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("the moment test execution ended..");
        System.out.println("-------------------");
        System.out.println("Start time : " + context.getEndDate());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test is starting...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " test is successfully executed...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " test is failed...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " test is skipped...");
    }

    // Automatically retries failed test scenarios
// IRetryAnalyzer Method Implemented
// This method will be automatically called to RETRY FAILED TEST SCENARIOS
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // RETRY COUNT

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer method added
// This automatically retries failed test scenarios using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Listener.class);
    }
}