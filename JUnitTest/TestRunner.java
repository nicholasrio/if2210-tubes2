package JunitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author asus
 */
import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure; 

public class TestRunner { 
    public static void main(String[] args) { 
        Result resultGroup = JUnitCore.runClasses(GroupJUnitTest.class); 
        for (Failure failure : resultGroup.getFailures()) { 
            System.out.println(failure.toString());
        }
        System.out.println(resultGroup.wasSuccessful()); 
        
        Result resultVideo = JUnitCore.runClasses(VideoJUnitTest.class); 
        for (Failure failure : resultVideo.getFailures()) { 
            System.out.println(failure.toString());
        }
        System.out.println(resultVideo.wasSuccessful());
        
        Result resultAdmin = JUnitCore.runClasses(AdminJUnitTest.class); 
        for (Failure failure : resultAdmin.getFailures()) { 
            System.out.println(failure.toString());
        }
        System.out.println(resultAdmin.wasSuccessful());
    } 
}
