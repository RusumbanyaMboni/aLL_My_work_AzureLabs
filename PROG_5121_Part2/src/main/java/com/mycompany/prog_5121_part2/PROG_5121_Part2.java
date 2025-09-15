package com.mycompany.prog_5121_part2;

import javax.swing.*;

public class PROG_5121_Part2 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        Login login = new Login();
        login.registerUser();

        if (login.getRegisteredUser() == null) {
            JOptionPane.showMessageDialog(null, "Registration failed. Exiting program.");
            return;
        }

        boolean running = true;
        while (running) {
            String[] options = {"1. Send Messages", "2. Show Recently Sent Messages", "3. Quit"};
            String choice = JOptionPane.showInputDialog(null, "Choose an option:\n1) Send Messages\n2) Show Recently Sent Messages\n3) Quit");

            if (choice == null) break;

            switch (choice) {
                case "1":
                    String input = JOptionPane.showInputDialog("How many messages would you like to send?");
                    if (input == null) break;

                    int numMessages;
                    try {
                        numMessages = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        break;
                    }

                    for (int i = 0; i < numMessages; i++) {
                        Message message = new Message();

                        if (!message.captureRecipient()) continue;
                        if (!message.captureMessage()) continue;

                        message.sendOptions();
                        JOptionPane.showMessageDialog(null, message.displayMessageDetails());
                    }

                    JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.getMessageCount());
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
}
