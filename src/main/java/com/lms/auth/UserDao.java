package com.lms.auth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.connection.JDBCConnection;

public class UserDao {

    public User register(User user) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO employee (empName, phoneNumber, pwd) VALUES ('"
                    + user.getName() + "', '" + user.getPhoneNumber() + "' , '" + user.getPwd() + "')");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public User logIn(ModelLogin login) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            if (login.getUserType().equals("Admin")) {
                User user = new User();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM admin WHERE phonenumber = '" + login.getPhoneNumber()
                                + "' AND pwd = '" + login.getPassword() + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("adminId"));
                    user.setName(resultSet.getString("adminName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
                    user.setIsBlock(resultSet.getBoolean("isBlock"));
                }
                return user;
            } else if (login.getUserType().equals("Employee")) {
                System.out.println("Employee");
                Employee user = new Employee();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM employee WHERE phonenumber = '" + login.getPhoneNumber()
                                + "' AND pwd = '" + login.getPassword() + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("empId"));
                    user.setName(resultSet.getString("empName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
                    user.setIsBlock(resultSet.getBoolean("isBlock"));
                }

                return user;

            } else if (login.getUserType().equals("Customer")) {
                Customer user = new Customer();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM customer WHERE phonenumber = '" + login.getPhoneNumber()
                                + "' AND pwd = '" + login.getPassword() + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("customerId"));
                    user.setName(resultSet.getString("customerName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
                    user.setIsBlock(resultSet.getBoolean("isBlock"));
                    user.setIsMember(resultSet.getBoolean("isMember"));
                }
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public User forGotPassword(String phoneNumber, String userType) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            User user = new User();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM " + userType + " WHERE phonenumber = '" + phoneNumber + "'");
            while (resultSet.next()) {
                user.setId(resultSet.getString("empId"));
                user.setName(resultSet.getString("empName"));
                user.setDob(resultSet.getString("dob"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setIsBlock(resultSet.getBoolean("isBlock"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public User updatePassword(User user) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE employee SET pwd = '" + user.getPwd() + "' WHERE empId = '" + user.getId()
                    + "'");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public List<User> getAllEmployeeList() {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("empId"));
                user.setName(resultSet.getString("empName"));
                user.setDob(resultSet.getString("dob"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setIsBlock(resultSet.getBoolean("isBlock"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
}
