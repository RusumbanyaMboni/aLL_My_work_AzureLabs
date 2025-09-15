package quickchat.quickchat;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class QuickChat {
    private static MessageStore messageStore = new MessageStore();
    private static String currentUser;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        Login login = new Login();
        login.registerUser();

        currentUser = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        String phoneNumber = JOptionPane.showInputDialog("Enter phone number:");

        boolean loggedIn = login.login(currentUser, password, phoneNumber);

        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting application.");
            return;
        }

        int maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
        int messageCount = 0;
        List<Message> messages = new ArrayList<>();

        boolean running = true;
        while (running) {
            String option = JOptionPane.showInputDialog(
                    "Choose an option:\n" +
                    "1) Send Message\n" +
                    "2) Show Recently Sent Messages\n" +
                    "3) Message Reports\n" +
                    "4) Quit"
            );

            switch (option) {
                case "1":
                    if (messageCount < maxMessages) {
                        Message message = new Message();
                        message.captureMessage(currentUser);
                        messages.add(message);
                        messageCount++;
                        
                        // Store message based on its status
                        switch (message.getStatus()) {
                            case "SENT":
                                messageStore.addSentMessage(message);
                                break;
                            case "DISREGARDED":
                                messageStore.addDisregardedMessage(message);
                                break;
                            case "STORED":
                                messageStore.addStoredMessage(message);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                    }
                    break;
                    
                case "2":
                    displayRecentMessages(messages);
                    break;
                    
                case "3":
                    showReportMenu();
                    break;
                    
                case "4":
                    running = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select again.");
            }
        }

        JOptionPane.showMessageDialog(null, "Session Summary:\n" +
                "Total messages created: " + messageCount + "\n" +
                "Sent messages: " + messageStore.getSentMessages().size() + "\n" +
                "Stored messages: " + messageStore.getStoredMessages().size() + "\n" +
                "Disregarded messages: " + messageStore.getDisregardedMessages().size());
    }

    private static void displayRecentMessages(List<Message> messages) {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages available.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Recent Messages ===\n");
        for (Message msg : messages) {
            sb.append(msg.getBasicInfo()).append("\nStatus: ").append(msg.getStatus()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void showReportMenu() {
        while (true) {
            String reportOption = JOptionPane.showInputDialog(
                    "=== Message Reports ===\n" +
                    "1) Display all senders and recipients\n" +
                    "2) Show longest message\n" +
                    "3) Search by message ID\n" +
                    "4) Search by recipient\n" +
                    "5) Delete message by hash\n" +
                    "6) Full message report\n" +
                    "7) Back to main menu"
            );

            switch (reportOption) {
                case "1":
                    messageStore.displaySendersAndRecipients();
                    break;
                case "2":
                    messageStore.displayLongestMessage();
                    break;
                case "3":
                    String searchId = JOptionPane.showInputDialog("Enter message ID to search:");
                    messageStore.searchByMessageId(searchId);
                    break;
                case "4":
                    String recipient = JOptionPane.showInputDialog("Enter recipient phone number to search:");
                    messageStore.searchByRecipient(recipient);
                    break;
                case "5":
                    String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
                    messageStore.deleteByHash(hash);
                    break;
                case "6":
                    messageStore.displayFullReport();
                    break;
                case "7":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
}