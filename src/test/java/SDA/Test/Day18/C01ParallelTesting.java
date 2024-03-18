package SDA.Test.Day18;

import SDA.Utilities.TestBase;
import org.testng.annotations.Test;
// Thread.currentThread().getId(): Returns the ID of the thread executing the method.
// Since there is no interference when this class is executed, the execution is sequential.
// If we want to make the tests in this class run in parallel, we can configure it in the XML file.
public class C01ParallelTesting  {
    @Test
    public void test01(){
      String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 01:" + threed);

    }    @Test
    public void test02(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 02:" + threed);

    }    @Test
    public void test03(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 03:" + threed);

    }    @Test
    public void test04(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 04:" + threed);

    }    @Test
    public void test05(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 05:" + threed);

    }    @Test
    public void test06(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 06:" + threed);

    }    @Test
    public void test07(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 07:" + threed);

    }    @Test
    public void test08(){
        String threed =  Thread.currentThread().getName();
        System.out.println("Thread executing for test 08:" + threed);

    }


}
