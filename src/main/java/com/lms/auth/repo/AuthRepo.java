package com.lms.auth.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.LoginModel;
import com.lms.auth.model.RegisterModel;
import com.lms.connection.JDBCConnection;

public class AuthRepo implements AuthDao {
    Connection connection = null;

    public AuthRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    public User register(RegisterModel register) {
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql;
            if (register.getUserType().equals("Admin")) {
                sql = "SELECT * FROM administrator WHERE phonenumber = ? AND pwd = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, register.getPhoneNumber());
                    pstmt.setString(2, register.getPassword());
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        return null;
                    }
                }

                sql = "INSERT INTO administrator (adminName, phoneNumber, gender, dob, pwd) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, register.getName());
                    pstmt.setString(2, register.getPhoneNumber());
                    pstmt.setNull(3, java.sql.Types.CHAR); // Assuming gender is CHAR type and can be null
                    pstmt.setNull(4, java.sql.Types.DATE); // Correctly setting null for DATE type
                    pstmt.setString(5, register.getPassword());
                    pstmt.executeUpdate();
                }

                Admin user = new Admin();
                user.setName(register.getName());
                user.setPhoneNumber(register.getPhoneNumber());
                user.setPwd(register.getPassword());
                user.setGender(null);
                user.setDob(null);
                return user;

            } else if (register.getUserType().equals("Employee")) {
                sql = "SELECT * FROM employee WHERE phonenumber = ? AND pwd = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, register.getPhoneNumber());
                    pstmt.setString(2, register.getPassword());
                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        return null;
                    }
                }

                sql = "INSERT INTO employee(empName, dob, phoneNumber, pwd, gender, isBlock) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, register.getName());
                    pstmt.setNull(2, java.sql.Types.DATE); // Correctly setting null for DATE type
                    pstmt.setString(3, register.getPhoneNumber());
                    pstmt.setString(4, register.getPassword());
                    pstmt.setNull(5, java.sql.Types.CHAR); // Assuming gender is CHAR type and can be null
                    pstmt.setBoolean(6, false); // Assuming isBlock is a boolean with a default value
                    pstmt.executeUpdate();
                }

                Employee user = new Employee();
                user.setName(register.getName());
                user.setPhoneNumber(register.getPhoneNumber());
                user.setPwd(register.getPassword());
                user.setGender(null);
                user.setDob(null);
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return null;
    }

    public User logIn(LoginModel login) {
        // Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            if (login.getUserType().equals("Admin")) {
                Admin user = new Admin();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM administrator WHERE phonenumber = '" + login.getPhoneNumber()
                                + "' AND pwd = '" + login.getPassword() + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("adminId"));
                    user.setName(resultSet.getString("adminName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
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

            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return null;
    }

    public User forgotPassword(String phoneNumber, String userType) {
        // Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            if (userType.equals("Admin")) {
                Admin user = new Admin();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM administrator WHERE phonenumber = '"
                        + phoneNumber + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("adminId"));
                    user.setName(resultSet.getString("adminName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
                }
                return user;
            } else if (userType.equals("Employee")) {
                Employee user = new Employee();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM employee WHERE phonenumber = '" + phoneNumber + "'");
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
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return null;
    }

    public User updatePassword(User user, String newPassword) {
        // Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println("UPDATE administrator SET pwd = '" + newPassword + "' WHERE adminId = '"
                        + admin.getId() + "'");
                statement.executeUpdate("UPDATE administrator SET pwd = '" + newPassword + "' WHERE adminId = '"
                        + admin.getId() + "'");
                admin.setPwd(newPassword);
                return admin;
            } else if (user instanceof Employee) {
                Employee employee = (Employee) user;
                statement.executeUpdate("UPDATE employee SET pwd = '" + newPassword + "' WHERE empid = '"
                        + employee.getId() + "'");
                employee.setPwd(newPassword);

                return employee;
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployeeList() {
        List<Employee> users = new ArrayList<Employee>();
        // Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                Employee user = new Employee();
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
        }
        return users;
    }

    public User getUserByPhoneNumber(String phoneNumber, String userType) {
        // Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            if (userType.equals("Admin")) {
                Admin user = new Admin();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM administrator WHERE phonenumber = '" + phoneNumber + "'");
                while (resultSet.next()) {
                    user.setId(resultSet.getString("adminId"));
                    user.setName(resultSet.getString("adminName"));
                    user.setDob(resultSet.getString("dob"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setPwd(resultSet.getString("pwd"));
                    user.setGender(resultSet.getString("gender"));
                }
                return user;
            } else if (userType.equals("Employee")) {
                System.out.println("Employee");
                Employee user = new Employee();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM employee WHERE phonenumber = '" + phoneNumber + "'");
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

            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return null;
    }
}