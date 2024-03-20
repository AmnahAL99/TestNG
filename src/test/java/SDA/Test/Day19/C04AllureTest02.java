package SDA.Test.Day19;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04AllureTest02 {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void test01(){
        System.out.println("Test 1 has passed");
    }

    @Test(enabled = false)
    @Severity(SeverityLevel.CRITICAL)
    public void test02(){
        System.out.println("Test 2 has passed");
    }

    @Test(timeOut = 1000)
    public void test03() throws InterruptedException {
        System.out.println("Test 3 has passed");
        Thread.sleep(2000);
    }

    @Test
    public void test04(){
        System.out.println("Test 4 has passed");
        Assert.assertEquals(4,5);
    }

    @Test
    public void test05(){
        System.out.println("Test 4 has passed");
        Assert.assertEquals(4,4);
    }
}
