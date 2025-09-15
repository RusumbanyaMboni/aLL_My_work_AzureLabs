package com.mycompany.prog_5121_part2;

import javax.swing.JOptionPane;
import java.util.Random;

public class Message {
    private static int messageCounter = 0;
    private String messageID;
    private String recipientCell;
    private String messageContent;
    private String messageHash;

    public Message() {
        this.messageID = generateMessageID();
        messageCounter++;
    }

    public static int getMessageCount() {
        return messageCounter;
    }

    private String generateMessageID() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public boolean captureRecipient() {
        recipientCell = JOptionPane.showInputDialog("Enter recipient number (+27xxxxxxxxx):");
        if (recipientCell == null) return false;
        if (!recipientCell.matches("^\\+27\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Invalid recipient number. Must be +27 followed by 9 digits.");
            return false;
        }
        return true;
    }

    public boolean captureMessage() {
        messageContent = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
        if (messageContent == null) return false;
        if (messageContent.length() > 250) {
            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
            return false;
        }
        return true;
    }

    private void createMessageHash() {
        String first2 = messageID.substring(0, 2);
        String count = String.valueOf(messageCounter);
        String[] words = messageContent.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        messageHash = (first2 + ":" + count + ":" + lastWord + firstWord).toUpperCase();
    }

    public void sendOptions() {
        String[] options = {"Send", "Discard", "Store Later"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose what to do with the message:\n" + messageContent,
                "Send Message",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {
            case 0:
                createMessageHash();
                JOptionPane.showMessageDialog(null, "Message sent.");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Message discarded.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Message saved to send later.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "No option selected.");
        }
    }

    public String displayMessageDetails() {
        return "Message Details:\n"
                + "Message ID: " + messageID + "\n"
                + "Message Hash: " + (messageHash != null ? messageHash : "N/A") + "\n"
                + "Recipient: " + recipientCell + "\n"
                + "Message: " + messageContent;
    }
}
