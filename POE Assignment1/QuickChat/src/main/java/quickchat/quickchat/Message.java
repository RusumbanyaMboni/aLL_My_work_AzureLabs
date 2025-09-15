package quickchat.quickchat;

import javax.swing.JOptionPane;
import java.util.Random;

public class Message {
    private String messageID;
    private String sender;  // Added sender field
    private String recipient;
    private String messageText;
    private String messageHash;
    private String status;  // Added status field (SENT, DISREGARDED, STORED)

    private static int messageCounter = 0;

    // Getters for all fields
    public String getMessageID() { return messageID; }
    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getStatus() { return status; }

    // Modified to accept sender as parameter
    public void captureMessage(String sender) {
        try {
            this.sender = sender;  // Set the sender
            messageID = String.format("%010d", new Random().nextInt(1_000_000_000));

            do {
                recipient = JOptionPane.showInputDialog("Enter recipient phone number (format: +27xxxxxxxxx):");
                if (recipient == null) {
                    status = "CANCELLED";
                    return;
                }
            } while (!checkRecipientCell(recipient));

            do {
                messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
                if (messageText == null) {
                    status = "CANCELLED";
                    return;
                }
                if (messageText.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Message too long! Maximum 250 characters allowed.");
                }
            } while (messageText.length() > 250);

            messageCounter++;
            createMessageHash();

            int choice = JOptionPane.showConfirmDialog(null,
                    "Message captured successfully!\n\n" +
                    "Choose an option:\n" +
                    "YES - Send Message Now\n" +
                    "NO - Discard Message\n" +
                    "CANCEL - Save for Later",
                    "Message Options", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (choice) {
                case JOptionPane.YES_OPTION:
                    status = "SENT";
                    JOptionPane.showMessageDialog(null, "Message sent successfully!\n\n" + getMessageDetails());
                    break;
                case JOptionPane.NO_OPTION:
                    status = "DISREGARDED";
                    JOptionPane.showMessageDialog(null, "Message discarded.");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    status = "STORED";
                    JOptionPane.showMessageDialog(null, "Message saved for later sending.");
                    break;
                default:
                    status = "CANCELLED";
                    JOptionPane.showMessageDialog(null, "Operation cancelled.");
            }
        } catch (Exception e) {
            status = "ERROR";
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    // Enhanced to include sender in details
    public String getMessageDetails() {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Sender: " + sender + "\n" +
               "Recipient: " + recipient + "\n" +
               "Status: " + status + "\n" +
               "Message: " + messageText;
    }

    // New method to get basic info for reports
    public String getBasicInfo() {
        return String.format("ID: %s | From: %s | To: %s | Chars: %d", 
               messageID, sender, recipient, messageText.length());
    }

    // New method to check if message matches a hash
    public boolean matchesHash(String hash) {
        return this.messageHash.equals(hash);
    }

    // Existing validation method
    private boolean checkRecipientCell(String phone) {
        if (!phone.matches("^\\+27\\d{9}$")) {
            JOptionPane.showMessageDialog(null,
                    "Cell phone number incorrectly formatted or does not contain international code.");
            return false;
        }
        return true;
    }

    // Existing hash creation method
    private void createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        messageHash = String.format("%s:%d: %s%s", messageID.substring(0, 2), messageCounter,
                firstWord.toUpperCase(), lastWord.toUpperCase());
    }
}