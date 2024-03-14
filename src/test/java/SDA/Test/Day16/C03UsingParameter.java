package SDA.Test.Day16;

import SDA.Utilities.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C03UsingParameter  {
//    @Test
//    @Parameters("name")
//    public void parameterTest(String name){
//        System.out.println("Welcome" + name);
//
//    }
    @Test
    @Parameters({"name","username","age"})
    public void parameterTest2(String name , String username ,String age){
        System.out.println("Welcome" +" "+ name + " " + username + " " + age);

    }
}
