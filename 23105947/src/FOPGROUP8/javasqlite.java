package FOPGROUP8;

import java.sql.*;
import java.util.Scanner;

public class javasqlite {

    // Method to validate email format without using regex
    public static boolean isValidEmail(String email) {
        // Check if the email contains "@" and at least one period after "@"
        int atPos = email.indexOf('@');
        int dotPos = email.indexOf('.', atPos);
        return atPos > 0 && dotPos > atPos;
    }

    // Method to validate password format (contains both letters and numbers)
    public static boolean isValidPassword(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        // Check if the password contains both letters and digits
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit; // Password must have both letters and digits
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu for user to choose between registration or login
        System.out.println("Select an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter 1 or 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline left by nextInt()

        if (choice == 1) {
            // Registration process
            String username = "";
            String email = "";
            String password = "";

            // Loop for valid username
            System.out.println("Enter username:");
            username = scanner.nextLine();

            // Loop for valid email
            while (true) {
                System.out.println("Enter email:");
                email = scanner.nextLine();

                // Validate email format
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format. Email must contain '@' and '.' after '@'.");
                } else {
                    break;  // Exit the loop if email is valid
                }
            }

            // Loop for valid password
            while (true) {
                System.out.println("Enter password:");
                password = scanner.nextLine();

                // Validate password format
                if (!isValidPassword(password)) {
                    System.out.println("Password must contain both letters and numbers.");
                } else {
                    break;  // Exit the loop if password is valid
                }
            }

            // Now insert the data into the database
            Connection conn = null;
            try {
                // Establish the database connection
                String url = "jdbc:sqlite:C:/Users/Acer/Documents/NetBeansProjects/23105947/23105947/information.db";
                conn = DriverManager.getConnection(url);

                // Check if email already exists
                String checkQuery = "SELECT * FROM user WHERE user_email = ? OR username = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                checkStmt.setString(1, email);
                checkStmt.setString(2, username);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Email or Username is already registered.");
                    return;
                }

                // Insert user data into the database
                String insertQuery = "INSERT INTO user (user_email, user_pass, username) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(insertQuery);
                stmt.setString(1, email);
                stmt.setString(2, password);
                stmt.setString(3, username);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Registration failed.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Error during registration.");
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing database connection.");
                }
            }
        } else if (choice == 2) {
            // Login process
            String usernameOrEmail = "";
            String password = "";

            // Get username/email for login
            System.out.println("Enter username or email:");
            usernameOrEmail = scanner.nextLine();

            // Get password for login
            System.out.println("Enter password:");
            password = scanner.nextLine();

            // Now check the credentials
            Connection conn = null;
            try {
                // Establish the database connection
                String url = "jdbc:sqlite:C:/Users/Acer/Documents/NetBeansProjects/23105947/23105947/information.db";
                conn = DriverManager.getConnection(url);

                // Query to check if the username/email and password are valid
                String loginQuery = "SELECT * FROM user WHERE (user_email = ? OR username = ?) AND user_pass = ?";
                PreparedStatement loginStmt = conn.prepareStatement(loginQuery);
                loginStmt.setString(1, usernameOrEmail);
                loginStmt.setString(2, usernameOrEmail);
                loginStmt.setString(3, password);

                ResultSet rs = loginStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username/email or password.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Error during login.");
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing database connection.");
                }
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}













