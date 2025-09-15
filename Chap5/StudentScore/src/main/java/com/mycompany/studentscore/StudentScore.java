/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentscore;

/**
 *
 * @author RC_Student_lab
 */import java.util.Scanner;
public class StudentScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        
        System.out.println("Enter student score: ");
        int Score = scanner.nextInt();
        
        if (Score >= 98){
            System.out.println("Grade: A");
        }else if(Score >= 75) {
            System.out.println("Grade; B");
        }else {
            System.out.println("Grade: C");
        }
        
    }
}
