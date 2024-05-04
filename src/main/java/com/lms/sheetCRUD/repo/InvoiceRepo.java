package com.lms.sheetCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.connection.JDBCConnection;
import com.lms.sheetCRUD.dal.InvoiceDao;
import com.lms.sheetCRUD.entities.Invoice;


public class InvoiceRepo implements InvoiceDao {

    Connection connection = null;

    public InvoiceRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override 
    public ArrayList<Invoice> getAll(){
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM invoice";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(resultSet.getString("invoiceId"));
                invoice.setEmpId(resultSet.getString("empId"));
                invoice.setMemberId(resultSet.getString("memberId"));
                invoice.setSaleDate(resultSet.getDate("saleDate").toString());
                invoice.setTotal(resultSet.getDouble("total"));
                invoices.add(invoice);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println(invoices.size());
        return invoices;
    }

    @Override
    public Invoice getById(String id){
        Invoice invoice = new Invoice();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM invoice WHERE invoiceId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                invoice.setInvoiceId(resultSet.getString("invoiceId"));
                invoice.setEmpId(resultSet.getString("empId"));
                invoice.setMemberId(resultSet.getString("memberId"));
                invoice.setSaleDate(resultSet.getDate("saleDate").toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return invoice;
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
