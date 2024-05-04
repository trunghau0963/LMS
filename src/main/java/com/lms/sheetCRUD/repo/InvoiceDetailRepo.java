package com.lms.sheetCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Array;

import com.lms.connection.JDBCConnection;
import com.lms.sheetCRUD.dal.InvoiceDetailDao;
import com.lms.sheetCRUD.entities.ExportBook;
import com.lms.sheetCRUD.entities.InvoiceDetail;

public class InvoiceDetailRepo implements InvoiceDetailDao {

    Connection connection = null;

    public InvoiceDetailRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public void getAll() {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM invoice_detail";
            Statement statement = connection.createStatement();
            while (statement.executeQuery(sql).next()) {
                System.out.println(statement.executeQuery(sql).getString("invoiceId") + " "
                        + statement.executeQuery(sql).getString("bookId") + " "
                        + statement.executeQuery(sql).getInt("quantity") + " "
                        + statement.executeQuery(sql).getFloat("cost"));
            }

            statement.executeQuery(sql);
            statement.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public InvoiceDetail getInvoiceDetail(String invoiceID) {
        InvoiceDetail invoiceDetail = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM invoice_detail WHERE invoiceId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, invoiceID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ExportBook> books = new ArrayList<>();
            while (resultSet.next()) {
                String bookId = resultSet.getString("bookId");
                int quantity = resultSet.getInt("quantity");
                float cost = resultSet.getFloat("cost");
                ExportBook book = new ExportBook(bookId, quantity, cost);
                books.add(book);
            }
            invoiceDetail = new InvoiceDetail(invoiceID, books);
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return invoiceDetail;
    }

    @Override
    public void insertIntoInvoice(String invoiceId, List<ExportBook> books) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO invoice_detail (invoiceId, bookId, quantity, cost)" +
                    "VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (ExportBook book : books) {
                preparedStatement.setString(1, invoiceId);
                preparedStatement.setString(2, book.getId()); // Assuming getId() returns the bookId
                preparedStatement.setInt(3, book.getQuantity());
                preparedStatement.setFloat(4, book.getExportPrice());

                preparedStatement.addBatch(); // Thêm câu lệnh INSERT vào lô lệnh
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void deleteSheet(String invoiceID) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "DELETE FROM invoice_detail WHERE invoiceId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, invoiceID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
