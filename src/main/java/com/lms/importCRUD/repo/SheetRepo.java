package com.lms.importCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lms.connection.JDBCConnection;
import com.lms.importCRUD.dal.SheetDao;

public class SheetRepo implements SheetDao {
    Connection connection = null;

    public SheetRepo() {
        connection = JDBCConnection.getJDBCConnection();
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
