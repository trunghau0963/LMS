package com.lms.exportCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lms.connection.JDBCConnection;
import com.lms.exportCRUD.entities.ExportBook;
import com.lms.exportCRUD.dal.InvoiceDetailDao;



public class InvoiceDetailRepo implements InvoiceDetailDao{
  
  Connection connection = null;

  public InvoiceDetailRepo() {
      connection = JDBCConnection.getJDBCConnection();
  }

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

}
