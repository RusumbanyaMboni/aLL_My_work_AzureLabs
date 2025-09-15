/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.withparameters;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class WithParameters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num1;
        int num2;
        
        System.out.println("Enter Num1: ");
        num1= scanner.nextInt();
        
        System.out.println("Enter Num2: ");
        num2=scanner.nextInt();
        
        int sum = num1 + num2;
        
        System.out.println("The sum is : "+ sum);
    }
}
