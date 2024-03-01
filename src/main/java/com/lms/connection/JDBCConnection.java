package com.lms.connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nttha
 */
public class JDBCConnection {
    public static Connection getJDBConnection() {
        Connection connection = null;
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Configure connection parameters
            String url = "jdbc:postgresql://localhost:5432/lms"; // Change to your Docker container's IP and database
                                                                  // name
            String username = "root"; // Change to your Docker container's username
            String password = "root"; // Change to your Docker container's password

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Connection successful
            System.out.println("Connected to the PostgreSQL server.");
            // System.out.println("Connection object: " + connection);

            // Perform database operations here

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return connection;
    }
}
