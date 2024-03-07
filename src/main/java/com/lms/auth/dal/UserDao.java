package com.lms.auth.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.ModelLogin;
import com.lms.auth.model.ModelRegister;
import com.lms.connection.JDBCConnection;

public class UserDao {

    public User register(ModelRegister register) {
        Connection connection = null;
        ResultSet resultSet;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            if (register.getUserType().equals("Admin")) {
                resultSet = statement
                        .executeQuery("SELECT * FROM administrator WHERE phonenumber = '" + register.getPhoneNumber()
                                + "' AND pwd = '" + register.getPassword() + "'");
                if (resultSet.next()) {
                    return null;
                }

                Admin user = new Admin();
                user.setName(register.getName());
                user.setPhoneNumber(register.getPhoneNumber());
                user.setPwd(register.getPassword());
                user.setGender(null);
                user.setDob(null);
                statement.executeUpdate("INSERT INTO administrator (adminName, phoneNumber, gender, dob, pwd) VALUES ('"
                        + user.getName() + "', '" + user.getPhoneNumber() + "', '" + user.getGender() + "', '"
                        + user.getDob() + "', '" + user.getPwd() + "')");

                return user;

            } else if (register.getUserType().equals("Employee")) {
                resultSet = statement
                        .executeQuery("SELECT * FROM employee WHERE phonenumber = '" + register.getPhoneNumber()
                                + "' AND pwd = '" + register.getPassword() + "'");
                if (resultSet.next()) {
                    return null;
                }

                Employee user = new Employee();
                user.setName(register.getName());
                user.setPhoneNumber(register.getPhoneNumber());
                user.setPwd(register.getPassword());
                user.setGender(null);
                user.setDob(null);
                statement
                        .executeUpdate("INSERT INTO employee(empName, dob, phoneNumber, pwd, gender, isBlock) VALUES ('"
                                + user.getName() + "', " + user.getDob() + ", '" + user.getPhoneNumber() + "', '"
                                + user.getPwd()
                                + "', " + user.getGender() + ", " + user.getIsBlock() + ")");
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

    public User logIn(ModelLogin login) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
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

    public User forgotPassword(String phoneNumber, String userType) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
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

    public User updatePassword(User user, String newPassword) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
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

    public List<Employee> getAllEmployeeList() {
        List<Employee> users = new ArrayList<Employee>();
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
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
