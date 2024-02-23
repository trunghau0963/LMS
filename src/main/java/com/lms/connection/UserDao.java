package com.lms.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.entities.User;

public class UserDao {
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
