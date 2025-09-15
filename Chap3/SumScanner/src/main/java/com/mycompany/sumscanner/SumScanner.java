/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumscanner;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class SumScanner {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       int num1;
       int num2;
       
       System.out.println("Enter First number: ");
       num1 = scanner.nextInt();
       
       System.out.println("Enter Second Number: ");
       num2 = scanner.nextInt();
       
       int sum = num1 + num2;
       
       System.out.println("the Sum is: ," + sum);
       
       
       
        
       
        
    }
}
