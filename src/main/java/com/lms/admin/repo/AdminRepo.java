package com.lms.admin.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.admin.dal.AdminDao;
import com.lms.admin.model.ModelAddUser;
import com.lms.admin.model.ModelEditAccount;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.connection.JDBCConnection;

public class AdminRepo implements AdminDao {

  public User addUser(ModelAddUser addUser) {
    Connection connection = null;
    ResultSet resultSet;
    try {
      System.out.println(addUser.getUserType());
      connection = JDBCConnection.getJDBConnection();
      Statement statement = connection.createStatement();
      if (addUser.getUserType().equals("Admin")) {
        resultSet = statement
            .executeQuery("SELECT * FROM administrator WHERE phonenumber = '" + addUser.getPhoneNumber()
                + "' AND pwd = '" + addUser.getPassword() + "'");
        if (resultSet.next()) {
          return null;
        }

        Admin user = new Admin();
        user.setName(addUser.getFullName());
        user.setPhoneNumber(addUser.getPhoneNumber());
        user.setPwd(addUser.getPassword());
        user.setGender(addUser.getGender());
        user.setDob(addUser.getDob());
        statement.executeUpdate("INSERT INTO administrator (adminName, phoneNumber, gender, dob, pwd) VALUES ('"
            + user.getName() + "', '" + user.getPhoneNumber() + "', '" + user.getGender() + "', '"
            + user.getDob() + "', '" + user.getPwd() + "')");

        return user;

      } else if (addUser.getUserType().equals("Employee")) {
        resultSet = statement
            .executeQuery("SELECT * FROM employee WHERE phonenumber = '" + addUser.getPhoneNumber()
                + "' AND pwd = '" + addUser.getPassword() + "'");
        if (resultSet.next()) {
          return null;
        }

        Employee user = new Employee();
        user.setName(addUser.getFullName());
        user.setPhoneNumber(addUser.getPhoneNumber());
        user.setPwd(addUser.getPassword());
        user.setGender(addUser.getGender());
        user.setDob(addUser.getDob());

        statement.executeUpdate("INSERT INTO employee(empName, dob, phoneNumber, pwd, gender, isBlock) VALUES ('"
            + user.getName() + "', '" + user.getDob() + "', '" + user.getPhoneNumber() + "', '"
            + user.getPwd() + "', '" + user.getGender() + "', " + user.getIsBlock() + ")");
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

  public boolean editAccount(ModelEditAccount editUser) {
    Connection connection = null;
    try {
      connection = JDBCConnection.getJDBConnection();
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

  public List<Employee> getEmployees() {

    Connection connection = null;
    ResultSet resultSet;
    List<Employee> users = new ArrayList<Employee>();
    try {
      connection = JDBCConnection.getJDBConnection();
      Statement statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM employee");
      while (resultSet.next()) {
        Employee user = new Employee();
        user.setName(resultSet.getString("empName"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setPwd(resultSet.getString("pwd"));
        user.setGender(resultSet.getString("gender"));
        user.setDob(resultSet.getString("dob"));
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

  public List<Admin> getAdmins() {
    Connection connection = null;
    ResultSet resultSet;
    List<Admin> users = new ArrayList<Admin>();
    try {
      connection = JDBCConnection.getJDBConnection();
      Statement statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM administrator");
      while (resultSet.next()) {
        Admin user = new Admin();
        user.setName(resultSet.getString("adminName"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setPwd(resultSet.getString("pwd"));
        user.setGender(resultSet.getString("gender"));
        user.setDob(resultSet.getString("dob"));
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


  public User getUserByPhoneNumber(String phoneNumber) {

    return null;
  }

  public User getUserByName(String name) {

    return null;
  }

}
