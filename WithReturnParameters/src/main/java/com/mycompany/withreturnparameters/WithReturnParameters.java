/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.withreturnparameters;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class WithReturnParameters {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       int num1;
       int num2;
       
        System.out.println("Enter num1: ");
        num1 = scanner.nextInt();
        
        System.out.println("Enter num2: " );
        num2 = scanner.nextInt();
        
        int sum = calculate(num1, num2);
        
        System.out.println("Enter Sum: "+ sum);
        
    }
    public static int calculate(int num1 , int num2) {
        int sum = num1 + num2;
        return sum;
    }
}
