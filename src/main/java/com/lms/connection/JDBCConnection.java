package com.lms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static Connection connection = null;

    private JDBCConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/ManagementBook";
            String username = "postgres"; // replace with your username
            String password = "0934117756minh"; // replace with your password

            connection = DriverManager.getConnection(url, username, password);

            // Connection successful
            System.out.println("Connected to the PostgreSQL server.");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
    }

    public static Connection getJDBCConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                new JDBCConnection();
            }
        } catch (SQLException e) {
            System.out.println("Failed to check if connection is closed.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection.");
            e.printStackTrace();
        }
    }
}