/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class Mavenproject1 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Enter current Year:");
       int currentYear = scanner.nextInt();
       
       System.out.print("Enter Birth year: ");
       int birthYear = scanner.nextInt();
       
       int age = currentYear - birthYear;
       
       System.out.print("The person's Age is : " + age);
    }
}
