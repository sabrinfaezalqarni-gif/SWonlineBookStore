/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sabreen
 */
    import java.sql.*;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            // This connects to the MySQL server currently running in your XAMPP
            String url = "jdbc:mysql://localhost:3306/onlinebookstore";
            String user = "root";
            String password = ""; 
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}

