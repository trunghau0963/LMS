package com.lms.informationCRUD.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lms.informationCRUD.model.ModelEditAccount;
import com.lms.informationCRUD.entities.Admin;
import com.lms.informationCRUD.entities.Employee;
import com.lms.informationCRUD.dal.InfoDao;
import com.lms.connection.JDBCConnection;

public class InfoRepo implements InfoDao {

    public static InfoRepo getInstance() {
        return new InfoRepo();
    }

    @Override
    public boolean editAccount(ModelEditAccount editUser) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE administrator SET adminName = '" + editUser.getFullName() + "', dob = '"
                    + editUser.getDob() + "', pwd = '" + editUser.getPwd() + "', gender = '" + editUser.getGender()
                    + "' WHERE phoneNumber = '"
                    + editUser.getPhoneNumber() + "'");

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
        return true;
    }

    @Override
    public boolean editEmployee(ModelEditAccount editUser) {
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE employee SET empName = '" + editUser.getFullName() + "', dob = '"
                    + editUser.getDob() + "', pwd = '" + editUser.getPwd() + "', gender = '" + editUser.getGender()
                    + "' WHERE phoneNumber = '"
                    + editUser.getPhoneNumber() + "'");

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
        return true;
    }

    @Override
    public Admin getAdminById(String id) {
        Connection connection = null;
        ResultSet resultSet;
        Admin user = new Admin();
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM administrator WHERE adminid = '" + id + "'");
            while (resultSet.next()) {
                user.setAdminId(resultSet.getString("adminid"));
                user.setName(resultSet.getString("adminname"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setDob(resultSet.getString("dob"));
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
        return user;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Connection connection = null;
        ResultSet resultSet;
        Employee user = new Employee();
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employee WHERE empid = '" + id + "'");
            while (resultSet.next()) {
                user.setEmpId(resultSet.getString("empid"));
                user.setName(resultSet.getString("empname"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setDob(resultSet.getString("dob"));
                user.setIsBlock(resultSet.getBoolean("isblock"));
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
        return user;
    }

    @Override
    public Employee getEmployeeByPhoneNumber(String phoneNumber) {
        Connection connection = null;
        ResultSet resultSet;
        Employee user = new Employee();
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employee WHERE phonenumber = '" + phoneNumber + "'");
            while (resultSet.next()) {
                user.setName(resultSet.getString("empname"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setDob(resultSet.getString("dob"));
                user.setIsBlock(resultSet.getBoolean("isblock"));
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
        return user;
    }

    @Override
    public Admin getAdminByPhoneNumber(String phoneNumber) {
        Connection connection = null;
        ResultSet resultSet;
        Admin user = new Admin();
        try {
            connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM administrator WHERE phonenumber = '" + phoneNumber + "'");
            while (resultSet.next()) {
                user.setAdminId(resultSet.getString("adminid"));
                user.setName(resultSet.getString("adminname"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setPwd(resultSet.getString("pwd"));
                user.setGender(resultSet.getString("gender"));
                user.setDob(resultSet.getString("dob"));
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
        return user;
    }

}
