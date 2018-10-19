/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tec.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sample.tec.util.MessageUtil;

/**
 *
 * @author kon5760
 */
public class BasicExampleTest {
    
   private String message = "Hello World";	
   private MessageUtil messageUtil = new MessageUtil("Hello world");

   @Test
   public void testPrintMessage() {
      assertEquals(message, messageUtil.printMessage());
   }
}
