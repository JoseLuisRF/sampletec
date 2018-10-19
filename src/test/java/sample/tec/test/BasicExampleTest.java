/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tec.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import sample.tec.Program;
import sample.tec.util.MessageUtil;


/**
 *
 * @author kon5760
 */
public class BasicExampleTest {
    
   private String message = "Hello World";	
   private MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() {
      assertEquals(message, messageUtil.printMessage());
   }

   @Test
   public void testNotNull() {
       Program p = new Program();
       assertThat(p, CoreMatchers.notNullValue());
   }
}
