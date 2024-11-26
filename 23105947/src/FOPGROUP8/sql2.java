package FOPGROUP8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class sql2 {
    
    public static void main(String[] args) {
        // Declare the connection object
        Connection conn = null;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String pass = sc.nextLine();

        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Database connection URL pointing to your SQLite file
            String url = "jdbc:sqlite:C:/Users/Acer/Documents/NetBeansProjects/23105947/information.db";

            // Establish the connection
            conn = DriverManager.getConnection(url); //the connection is establisbed using this, and if its established, conn will contain a valid connection object. but if its not established, it will remain null.
            System.out.println("Connection to SQLite has been established.");

            // You can add more code here to interact with the database
            // Example: Creating tables, inserting data, etc.

        } catch (SQLException e) {
            System.out.println("A database error occurred.");
        } catch (ClassNotFoundException e) {
            System.out.println("The SQLite JDBC driver was not found.");
        } finally {
            // Close the connection if it was successfully created
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException ex) {
                    System.out.println("An error occurred while closing the connection.");
                }
            }
        }
    }
}



    

