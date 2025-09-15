/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog_5121_part2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testGetMessageCount() {
        System.out.println("getMessageCount");
        int expResult = 0;
        int result = Message.getMessageCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCaptureRecipient() {
        System.out.println("captureRecipient");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.captureRecipient();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCaptureMessage() {
        System.out.println("captureMessage");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.captureMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSendOptions() {
        System.out.println("sendOptions");
        Message instance = new Message();
        instance.sendOptions();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisplayMessageDetails() {
        System.out.println("displayMessageDetails");
        Message instance = new Message();
        String expResult = "";
        String result = instance.displayMessageDetails();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
