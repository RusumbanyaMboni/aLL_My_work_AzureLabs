/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gui_sumofnumbers;

/**
 *
 * @author RC_Student_lab
 */import javax.swing.JOptionPane;
public class Gui_SumOfNumbers {

    public static void main(String[] args){
        String number1 = JOptionPane.showInputDialog("Enter First Number: ");
        String number2 = JOptionPane.showInputDialog("Enter Second Number: ");
        
        int Number1 = Integer.parseInt(number1);
        int Number2 = Integer.parseInt(number2);
        
        int sum = Number1 + Number2;
        
        JOptionPane.showMessageDialog(null,"SUM is : "+ sum);
        
        

    }
    
}
