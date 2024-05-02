package com.lms.importCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lms.connection.JDBCConnection;
import com.lms.importCRUD.dal.SheetDetailDao;
import com.lms.importCRUD.entities.ImportBook;

public class SheetDetailRepo implements SheetDetailDao {
    Connection connection = null;

    public SheetDetailRepo() {
        connection = JDBCConnection.getJDBCConnection();
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

}
