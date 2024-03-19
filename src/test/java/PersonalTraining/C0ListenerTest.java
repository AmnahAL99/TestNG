package PersonalTraining;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (MyPractice.Task2.ListenerTest.class)
public class C0ListenerTest {

    @Test
    public void Test1(){
        System.out.println("login tested 1");}
    @Test
    public void Test2(){
        System.out.println("login tested 2");
       // throw new SkipException("Skipped");
        throw new RuntimeException("filer");

    }

}
