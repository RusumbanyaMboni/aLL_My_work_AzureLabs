package quickchat.quickchat;

public class User {
    private String firstName, lastName, username, password, phone;

    public User(String firstName, String lastName, String username, String password, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
