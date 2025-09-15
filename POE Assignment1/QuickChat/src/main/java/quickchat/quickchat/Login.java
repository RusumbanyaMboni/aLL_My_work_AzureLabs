package quickchat.quickchat;

public class Login {
    private User registeredUser;

    // Validation Methods for Unit Testing
    public boolean validateUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean validatePassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    public boolean validatePhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }
    //This regular expression was created with the help of ChatGPT, an artificial intelligence tool developed by OpenAI, which uses natural language processing to assist with tasks such as coding and regex creation.

//Reference (APA Style):
//OpenAI. (2024). ChatGPT (Apr 12 version) [Large language model]. https://chat.openai.com



    // Overloaded register method for unit testing
    public void registerUser(String firstName, String lastName, String username, String password, String phone) {
        if (!validateUsername(username)) {
            return;
        }
        if (!validatePhoneNumber(phone)) {
            return;
        }
        registeredUser = new User(firstName, lastName, username, password, phone);
    }

    // Existing JOptionPane version (unchanged for runtime use)
    public void registerUser() {
        String firstName = javax.swing.JOptionPane.showInputDialog("Enter your first name:");
        String lastName = javax.swing.JOptionPane.showInputDialog("Enter your last name:");
        String username = javax.swing.JOptionPane.showInputDialog("Enter a username (must contain '_' and be <= 5 characters):");
        String password = javax.swing.JOptionPane.showInputDialog("Enter a password:");
        String phone = javax.swing.JOptionPane.showInputDialog("Enter South African phone number (+27xxxxxxxxx):");

        if (!validateUsername(username)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Username is not correctly formatted. It must contain an underscore and be no more than 5 characters.");
            return;
        }

        if (!validatePhoneNumber(phone)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }

        registeredUser = new User(firstName, lastName, username, password, phone);
        javax.swing.JOptionPane.showMessageDialog(null, "User successfully registered.");
    }

    public boolean login(String username, String password, String phone) {
        if (registeredUser == null) {
            return false;
        }

        return username.equals(registeredUser.getUsername()) &&
               password.equals(registeredUser.getPassword()) &&
               phone.equals(registeredUser.getPhone());
    }
}
