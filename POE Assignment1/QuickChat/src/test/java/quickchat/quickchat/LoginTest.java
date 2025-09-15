package quickchat.quickchat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

public class LoginTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login();
        assertTrue(login.validateUsername("abc_d"), "Username should be valid");
        assertFalse(login.validateUsername("abcd"), "Username missing underscore");
        assertFalse(login.validateUsername("abcdef_"), "Username too long");
    }

    @Test
    public void testPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.validatePassword("Chi&sec@kegg!"), "Valid password should pass");
        assertFalse(login.validatePassword("password"), "Simple password should fail");
    }

    @Test
    public void testPhoneNumberValidation() {
        Login login = new Login();
        assertTrue(login.validatePhoneNumber("+27838963976"), "Valid phone number should pass");
        assertFalse(login.validatePhoneNumber("08966553"), "Invalid phone number should fail");
    }

    @Test
    public void testLoginSuccessAndFailure() {
        Login login = new Login();
        login.registerUser("John", "Doe", "john_", "Test@1234", "+27821234567");

        assertTrue(login.login("john_", "Test@1234", "+27821234567"), "Login should succeed");
        assertFalse(login.login("wrong_", "wrongpass", "+27821234567"), "Login should fail");
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
    public void testRegisterUser_5args() {
        System.out.println("registerUser");
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String phone = "";
        Login instance = new Login();
        instance.registerUser(firstName, lastName, username, password, phone);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterUser_0args() {
        System.out.println("registerUser");
        Login instance = new Login();
        instance.registerUser();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        String phone = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.login(username, password, phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
