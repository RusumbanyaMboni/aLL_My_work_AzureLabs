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
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login instance = new Login();
        instance.registerUser();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        String username = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidatePhoneNumber() {
        System.out.println("validatePhoneNumber");
        String phone = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validatePhoneNumber(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRegisteredUser() {
        System.out.println("getRegisteredUser");
        Login instance = new Login();
        User expResult = null;
        User result = instance.getRegisteredUser();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
