package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 
@RunWith(Suite.class)
@SuiteClasses({RegistarAjudaTests.class})
 
public class JUnitTestSuite {
@BeforeClass
    public static void printMe() {
        System.out.println("JUnitTestSuite is the test suite grouping       testcase 1 and testcase 2");
 
}
}