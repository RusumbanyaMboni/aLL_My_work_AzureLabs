/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */

import java.util.Scanner;

public class Login {
    private User registeredUser;
    private Scanner scanner = new Scanner(System.in);

    public void registerUser() {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        if (firstName.isEmpty()) return;

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        if (lastName.isEmpty()) return;

        String username;
        do {
            System.out.print("Enter a username (must contain '_' and be <= 5 characters): ");
            username = scanner.nextLine();
        } while (!validateUsername(username));

        String password;
        do {
            System.out.print("Enter a password (min 8 chars, 1 uppercase, 1 number, 1 special char): ");
            password = scanner.nextLine();
        } while (!validatePassword(password));

        String phone;
        do {
            System.out.print("Enter South African phone number (+27xxxxxxxxx): ");
            phone = scanner.nextLine();
        } while (!validatePhoneNumber(phone));

        registeredUser = new User(firstName, lastName, username, password, phone);
        System.out.println("User successfully registered.\nWelcome " + firstName + " " + lastName + ", it is great to see you.");
    }

    public boolean validateUsername(String username) {
        boolean valid = username.contains("_") && username.length() <= 5;
        if (!valid) {
            System.out.println("Username is not correctly formatted.\nPlease ensure that your username contains an underscore and is no more than five characters in length.");
        }
        return valid;
    }

    public boolean validatePassword(String password) {
        boolean valid = password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
        if (!valid) {
            System.out.println("Password is not correctly formatted.\nPlease ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        } else {
            System.out.println("Password successfully captured.");
        }
        return valid;
    }

    public boolean validatePhoneNumber(String phone) {
        boolean valid = phone.matches("^\\+27\\d{9}$");
        if (!valid) {
            System.out.println("Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
        } else {
            System.out.println("Cell number successfully captured.");
        }
        return valid;
    }

    // Getter for registered user (for later login)
    public User getRegisteredUser() {
        return registeredUser;
    }
}
