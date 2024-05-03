package com.lms.exportCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lms.connection.JDBCConnection;
import com.lms.exportCRUD.dal.InvoiceDao;


public class InvoiceRepo implements InvoiceDao {

    Connection connection = null;

    public InvoiceRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public String createInvoice(String empId, String customerId, String date) {
        String id = null;

        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO invoice (empId, memberId, saleDate) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, empId);
            preparedStatement.setString(2, customerId);
            preparedStatement.setDate(3, java.sql.Date.valueOf(date));

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
