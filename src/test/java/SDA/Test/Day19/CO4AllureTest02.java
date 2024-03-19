package SDA.Test.Day19;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CO4AllureTest02 {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void test01(){
        System.out.println("test1...pass");
    }
    @Test (enabled = false)
    @Severity(SeverityLevel.CRITICAL)

    public void test02(){
        System.out.println("test2...pass");
    }

    @Test(timeOut = 1000)
    public void test03() throws InterruptedException {
        System.out.println("test3...pass");
        Thread.sleep(2000);
    }

    @Test
    public void test04(){
        System.out.println("test4...pass");

    }
}
