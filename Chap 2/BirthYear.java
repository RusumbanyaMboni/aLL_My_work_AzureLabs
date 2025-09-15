/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.birthyear;

/**
 *
 * @author RC_Student_lab
 */import javax.swing.JOptionPane;
public class BirthYear {

    public static void main(String[] args) {
       String currentYear = JOptionPane.showInputDialog("Enter Current Year: ");
       String birthYear = JOptionPane.showInputDialog("Enter Birth Year: ");
       
       int CurrentYear = Integer.parseInt(currentYear);
       int BirthYear = Integer.parseInt(birthYear);
       
       int age = CurrentYear - BirthYear;
       
       JOptionPane.showMessageDialog(null, "age is: "+ age);
    }
}
