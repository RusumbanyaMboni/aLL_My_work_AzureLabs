/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.scanersum;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
public class ScanerSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numeber");
        int firstnum = input.nextInt();
        
        System.out.println("Enter numeber2");
        int secondnum = input.nextInt();
        int Product = firstnum * secondnum;
     
        
        System.out.println("product:" + Product);
        
    
    }
}
