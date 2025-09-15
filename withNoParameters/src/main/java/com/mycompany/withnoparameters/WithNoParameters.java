/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.withnoparameters;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class WithNoParameters {

    public static void main(String[] args) {
        sum();
    }
    public static void sum(){
      
        int number1;
        int number2;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter First number: ");
        number1 = scanner.nextInt();
        
        System.out.println("Enter second number: ");
        number2 = scanner.nextInt();
        
        int sum = number1 + number2 ;
        
        System.out.println("The sum is: " + sum);
        
        
       
    }
}
