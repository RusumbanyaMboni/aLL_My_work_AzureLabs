/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nestedif;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class NestedIF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;
        boolean hasLicense;
        
        System.out.println("Enter your Age: ");
        age = scanner.nextInt();
        
       
        
        if (age >= 18) {
        System.out.println("Do you have a License: ");
        hasLicense = scanner.nextBoolean();
            if (hasLicense){
                System.out.println("You can drive.");
            }else {
                System.out.println("Get your license first!");
            }
        }else{
            System.out.println("You are too young to drive.");
        }
        
      
      
    }
}
