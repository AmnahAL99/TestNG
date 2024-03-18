package SDA.Test.Day18;

import org.testng.annotations.Test;

public class C03ParallelTestParameter {
    @Test(threadPoolSize = 4, invocationCount = 8,timeOut = 1000)
    public  void test(){
        System.out.println("Thread Id is :" +Thread.currentThread().threadId());

    }
}
