package com.lms.dataSaleCRUD.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.connection.JDBCConnection;
import com.lms.dataSaleCRUD.entities.Book;


public class UserDao {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
    
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setBookId(resultSet.getString("bookId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));

                books.add(book);
            }
        } catch(SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }
}
