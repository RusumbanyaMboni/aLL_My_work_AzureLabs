/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.greetinguser;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner; //import scanner class

public class GreetingUser {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create scanner object
        
        System.out.println("Enter your name: ");
        String name = input.nextLine();  //Read user input
        
        greetUser(name);  // Call the Method with user input
        
        input.close();  // Close the scanner (good practice)
       
    }
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
