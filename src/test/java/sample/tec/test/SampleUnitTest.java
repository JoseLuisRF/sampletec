/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tec.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kon5760
 */
public class SampleUnitTest {
        @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            
            //Method annotated with `@BeforeClass` will execute once before any of the test methods in this class.

            //This method could be used to set up any test fixtures that are computationally expensive and shared by several test methods. e.g. establishing database connections 

            //Sometimes several tests need to share computationally expensive setup (like logging into a database). While this can compromise the independence of tests, sometimes it is a necessary optimization. From http://junit.sourceforge.net/javadoc/org/junit/BeforeClass.html
           System.out.println("setUpBeforeClass");
        }

        @AfterClass
        public static void tearDownAfterClass() throws Exception {
            
            //Method annotated with `@AfterClass` will execute once after all of the test methods are executed in this class.

            //If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run. Annotating a public static void method with @AfterClass causes that method to be run after all the tests in the class have been run. All @AfterClass methods are guaranteed to run even if a BeforeClass method throws an exception. From http://junit.sourceforge.net/javadoc/org/junit/AfterClass.html
            System.out.println("tearDownAfterClass");
        }

        @Before
        public void setUp() throws Exception {
             //Method annotated with `@Before` will execute before each test method in this class is executed.

             //If you find that several tests need similar objects created before they can run this method could be used to do set up those objects (aka test-fixtures).
             System.out.println("setUp");
        }
        
        @After
        public void tearDown() throws Exception {
             
             //Method annotated with `@After` will execute after each test method in this class is executed.

             //If you allocate external resources in a Before method you must release them in this method.
             System.out.println("tearDown");
        }

        @Test
        public void test1() {
           
           //A public void method annotated with @Test will be executed as a test case.
           System.out.println("test1");
        }

        @Test
        public void test2() {
   
            //Another test cases
            System.out.println("test2");
        }

}
