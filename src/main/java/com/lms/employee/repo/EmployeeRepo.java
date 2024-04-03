package com.lms.employee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.lms.auth.entities.Employee;
import com.lms.connection.JDBCConnection;
import com.lms.employee.dal.EmployeeDao;

public class EmployeeRepo implements EmployeeDao {
    Connection connection = null;

    public EmployeeRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public Employee editInfo(String empId, String empName, String dob, String pwd, String gender) {
        Employee emp = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "Update employee set empName = ?, dob = ?, pwd = ?, gender = ? Where empId = ?";
            PreparedStatement statement = connection.prepareStatement(stmt);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate;
            java.sql.Date sqlDate;
            try {
                parsedDate = dateFormat.parse(dob);
                sqlDate = new java.sql.Date(parsedDate.getTime());
                statement.setDate(2, sqlDate);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            statement.setString(1, empName);
            statement.setString(3, pwd);
            statement.setString(4, gender.toLowerCase());
            statement.setString(5, empId);

            statement.execute();

            stmt = "SELECT * FROM AUTHOR WHERE authorId = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, empId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                emp = new Employee();
                emp.setId(resultSet.getString("empId"));
                emp.setName(resultSet.getString("empName"));
                emp.setDob(resultSet.getString("dob"));
                emp.setPwd(resultSet.getString("pwd"));
                emp.setPhoneNumber(resultSet.getString("phoneNumber"));
                emp.setGender(resultSet.getString("gender"));
            }

            JOptionPane.showMessageDialog(null, "Edit info successfully");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public Employee getInfoEmpById(String id) {
        Employee emp = new Employee();
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "SELECT * FROM employee WHERE empId ILIKE ?";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + id + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                emp.setId(resultSet.getString("empId"));
                emp.setName(resultSet.getString("empName"));
                emp.setDob(resultSet.getString("dob"));
                emp.setPwd(resultSet.getString("pwd"));
                emp.setPhoneNumber(resultSet.getString("phoneNumber"));
                emp.setGender(resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return emp;
    }

}
