package com.lms.sheetCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lms.connection.JDBCConnection;
import com.lms.sheetCRUD.dal.SheetDetailDao;
import com.lms.sheetCRUD.entities.ImportBook;

public class SheetDetailRepo implements SheetDetailDao {
    Connection connection = null;

    public SheetDetailRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public void getAll() {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sheet_detail";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("sheetId") + " " + resultSet.getString("bookId") + " "
                        + resultSet.getInt("quantity") + " " + resultSet.getFloat("importPrice"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void getSheetDetail(String sheetId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sheet_detail WHERE sheetId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sheetId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("sheetId") + " " + resultSet.getString("bookId") + " "
                        + resultSet.getInt("quantity") + " " + resultSet.getFloat("importPrice"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void insertIntoSheet(String sheetId, List<ImportBook> books) {
        try {
            System.out.println(sheetId);
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO sheet_detail (sheetId, bookId, quantity, importPrice)" +
                    "VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (ImportBook book : books) {
                preparedStatement.setString(1, sheetId);
                preparedStatement.setString(2, book.getId()); // Assuming getId() returns the bookId
                preparedStatement.setInt(3, book.getQuantity());
                preparedStatement.setFloat(4, book.getImportPrice());

                preparedStatement.addBatch(); // Thêm câu lệnh INSERT vào lô lệnh
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void deleteSheet(String sheetId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "DELETE FROM sheet WHERE sheetId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sheetId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
