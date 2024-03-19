package PersonalTraining;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class C1ListenerTest {

    @Test
    public void Test1(){
        System.out.println("login tested 1");}
    @Test
    public void Test2(){
        System.out.println("login tested 2");
       // throw new SkipException("Skipped");
       // throw new RuntimeException("filer");

    }

}

/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="All Test Suite">
    <listeners>

    <listener class-name="MyPractice.Task2.ListenerTest"> </listener>
        <listener class-name="org.testng.reporters.EmailableReporter"> </listener>
    </listeners>
    <test verbose="2" preserve-order="true"
          name="C1ListenerTest.java">
        <classes>
            <class name="PersonalTraining.C1ListenerTest">

            </class>
        </classes>
    </test>
</suite>
 */