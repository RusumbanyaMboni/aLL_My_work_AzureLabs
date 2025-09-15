package quickchat.quickchat;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class MessageStore {
    private List<Message> sentMessages = new ArrayList<>();
    private List<Message> disregardedMessages = new ArrayList<>();
    private List<Message> storedMessages = new ArrayList<>();
    private List<String> messageHashes = new ArrayList<>();
    private List<String> messageIds = new ArrayList<>();

    // Add message methods
    public void addSentMessage(Message message) {
        sentMessages.add(message);
        messageHashes.add(message.getMessageHash());
        messageIds.add(message.getMessageID());
    }

    public void addDisregardedMessage(Message message) {
        disregardedMessages.add(message);
        messageHashes.add(message.getMessageHash());
        messageIds.add(message.getMessageID());
    }

    public void addStoredMessage(Message message) {
        storedMessages.add(message);
        messageHashes.add(message.getMessageHash());
        messageIds.add(message.getMessageID());
    }

    // Getter methods for the lists
    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getStoredMessages() {
        return storedMessages;
    }

    public List<Message> getDisregardedMessages() {
        return disregardedMessages;
    }

    // Reporting methods
    public void displaySendersAndRecipients() {
        StringBuilder sb = new StringBuilder("=== Senders and Recipients ===\n");
        for (Message msg : sentMessages) {
            sb.append("From: ").append(msg.getSender())
              .append(" → To: ").append(msg.getRecipient()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void displayLongestMessage() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages available.");
            return;
        }

        Message longest = sentMessages.get(0);
        for (Message msg : sentMessages) {
            if (msg.getMessageText().length() > longest.getMessageText().length()) {
                longest = msg;
            }
        }
        JOptionPane.showMessageDialog(null, "=== Longest Message ===\n" + longest.getMessageDetails());
    }

    public void searchByMessageId(String id) {
        for (Message msg : sentMessages) {
            if (msg.getMessageID().equals(id)) {
                JOptionPane.showMessageDialog(null, "=== Message Found ===\n" + 
                    "Recipient: " + msg.getRecipient() + "\n" +
                    "Message: " + msg.getMessageText());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No message found with ID: " + id);
    }

    public void searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder("=== Messages to " + recipient + " ===\n");
        boolean found = false;
        for (Message msg : sentMessages) {
            if (msg.getRecipient().equals(recipient)) {
                sb.append("From: ").append(msg.getSender())
                  .append(" - ").append(msg.getMessageText()).append("\n\n");
                found = true;
            }
        }
        if (!found) {
            sb.append("No messages found for this recipient.");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void deleteByHash(String hash) {
        for (int i = 0; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).getMessageHash().equals(hash)) {
                sentMessages.remove(i);
                JOptionPane.showMessageDialog(null, "Message deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No message found with hash: " + hash);
    }

    public void displayFullReport() {
        StringBuilder sb = new StringBuilder("=== Full Message Report ===\n");
        for (Message msg : sentMessages) {
            sb.append(msg.getMessageDetails()).append("\n\n");
        }
        if (sentMessages.isEmpty()) {
            sb.append("No messages available.");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}