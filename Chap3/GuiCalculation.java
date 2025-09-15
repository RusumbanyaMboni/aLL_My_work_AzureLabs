/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.guicalculation;

/**
 *
 * @author RC_Student_lab
 */import javax.swing.JOptionPane;
public class GuiCalculation {
    public static void main(String[] args){
        String Number1= JOptionPane.showInputDialog("Enter First number:");
        String Number2= JOptionPane.showInputDialog("Enter Second number: ");
        
        int number1 = Integer.parseInt(Number1);
        int number2 = Integer.parseInt(Number2);
        
        int sum= number1 + number2;
        
        JOptionPane.showMessageDialog(null,"The sum is:," + sum);
         
    }
    
       
        
        
}
