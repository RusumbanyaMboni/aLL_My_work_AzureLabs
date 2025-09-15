/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_5121_part2;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private User registeredUser;

    public void registerUser() {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        if (firstName == null) return;

        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        if (lastName == null) return;

        String username;
        do {
            username = JOptionPane.showInputDialog("Enter a username (must contain '_' and be <= 5 characters):");
            if (username == null) return;
        } while (!validateUsername(username));

        String password;
        do {
            password = JOptionPane.showInputDialog("Enter a password (min 8 chars, 1 uppercase, 1 number, 1 special char):");
            if (password == null) return;
        } while (!validatePassword(password));

        String phone;
        do {
            phone = JOptionPane.showInputDialog("Enter South African phone number (+27xxxxxxxxx):");
            if (phone == null) return;
        } while (!validatePhoneNumber(phone));

        registeredUser = new User(firstName, lastName, username, password, phone);
        JOptionPane.showMessageDialog(null, "User successfully registered.\nWelcome " + firstName + " " + lastName + ", it is great to see you.");
    }

    public boolean validateUsername(String username) {
        boolean valid = username.contains("_") && username.length() <= 5;
        if (!valid) {
            JOptionPane.showMessageDialog(null,
                "Username is not correctly formatted.\nPlease ensure that your username contains an underscore and is no more than five characters in length.");
        }
        return valid;
    }

    public boolean validatePassword(String password) {
        boolean valid = password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
        if (!valid) {
            JOptionPane.showMessageDialog(null,
                "Password is not correctly formatted.\nPlease ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        } else {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        }
        return valid;
    }

    public boolean validatePhoneNumber(String phone) {
        boolean valid = phone.matches("^\\+27\\d{9}$");
        if (!valid) {
            JOptionPane.showMessageDialog(null,
                "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
        } else {
            JOptionPane.showMessageDialog(null, "Cell number successfully captured.");
        }
        return valid;
    }
    /*
 * Reference:
 * OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. https://chat.openai.com/chat
 */

    // Getter for registered user (for later login)
    public User getRegisteredUser() {
        return registeredUser;
    }
}
