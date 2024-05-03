package com.lms.sheetCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.connection.JDBCConnection;
import com.lms.sheetCRUD.dal.SheetDao;
import com.lms.sheetCRUD.entities.Sheet;

public class SheetRepo implements SheetDao {
    Connection connection = null;

    public SheetRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public ArrayList<Sheet> getAll() {
        ArrayList<Sheet> sheets = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sheet";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Sheet sheet = new Sheet();
                sheet.setSheetId(resultSet.getString("sheetId"));
                sheet.setResponsible(resultSet.getString("responsible"));
                sheet.setDate(resultSet.getDate("importDate").toString());
                sheet.setTotalCost(resultSet.getFloat("totalCost"));
                sheets.add(sheet);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return sheets;
    }

    @Override
    public Sheet getById(String id) {
        Sheet sheet = new Sheet();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sheet WHERE sheetId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sheet.setSheetId(resultSet.getString("sheetId"));
                sheet.setResponsible(resultSet.getString("responsible"));
                sheet.setDate(resultSet.getDate("importDate").toString());
                sheet.setTotalCost(resultSet.getFloat("totalCost"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return sheet;
    }

    @Override
    public String createSheet(String importdate, String responsible) {
        String id = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO sheet(responsible, importDate)\r\n" +
                    "VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, responsible);
            preparedStatement.setDate(2, java.sql.Date.valueOf(importdate));

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getString(1); // Lấy giá trị invoiceId trả về
                } else {
                    // Xử lý trường hợp không có giá trị trả về
                }
                generatedKeys.close();
            } else {
                // Xử lý trường hợp không có hàng nào được chèn
            }
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return id;
    }
}
