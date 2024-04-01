package com.lms.employee.repo;

import com.lms.employee.dal.EmployeeDao;
import com.lms.employee.entities.*;
import com.lms.employee.model.*;
import com.lms.connection.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements EmployeeDao {

  public Sheet addSheet(ImportModel newSheet) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet generatedKeys = null;

    try {
      connection = JDBCConnection.getJDBConnection();

      // Specify that you want to retrieve the auto-generated keys
      statement = connection.prepareStatement("INSERT INTO sheet (responsible, importdate, totalcost) VALUES (?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      // Set values for the prepared statement
      statement.setString(1, newSheet.getImportBy());
      statement.setDate(2,
          new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(newSheet.getImportDate()).getTime()));
      statement.setDouble(3, newSheet.getTotalCost());

      // Execute the insert statement
      int affectedRows = statement.executeUpdate();

      if (affectedRows == 0) {
        throw new SQLException("Inserting sheet failed, no rows affected.");
      }

      // Retrieve the auto-generated keys
      generatedKeys = statement.getGeneratedKeys();

      if (generatedKeys.next()) {
        String id = generatedKeys.getString(1); // Assuming the auto-generated key is of type STRING
        Sheet sheet = new Sheet();
        sheet.setSheetId(id); // Set the auto-generated ID to the Sheet object
        sheet.setResponsiblePerson(newSheet.getImportBy());
        sheet.setSheetDate(newSheet.getImportDate());
        sheet.setTotalcost(newSheet.getTotalCost());
        return sheet;
      } else {
        throw new SQLException("Inserting sheet failed, no ID obtained.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // Close resources in finally block
      try {
        if (generatedKeys != null)
          generatedKeys.close();
        if (statement != null)
          statement.close();
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  public List<Sheet> getAllSheets() {
    Connection connection = null;
    List<Sheet> sheets = new ArrayList<Sheet>();

    try {
      connection = JDBCConnection.getJDBConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM sheet");
      while (resultSet.next()) {
        Sheet sheet = new Sheet();
        sheet.setSheetDate(resultSet.getString("importdate"));
        sheet.setResponsiblePerson(resultSet.getString("responsible"));
        sheet.setTotalcost(resultSet.getDouble("totalcost"));
        sheets.add(sheet);
      }
      return sheets;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

    return null;
  }
}
