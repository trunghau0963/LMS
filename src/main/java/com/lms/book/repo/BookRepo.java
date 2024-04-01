package com.lms.book.repo;

import com.lms.connection.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lms.book.entities.Book;
import com.lms.book.dal.BookDao;

public class BookRepo implements BookDao {

    @Override
    public Book findById(String bookId) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                return book;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM book WHERE title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                return book;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM book";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean add(Book newBook) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "INSERT INTO book (title, publisherId, salePrice) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getPublisherId());
            preparedStatement.setFloat(3, newBook.getSalePrice());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "UPDATE book SET publisherId = ?, title = ?, salePrice = ?, isHide = ? WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getPublisherId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setDouble(3, book.getSalePrice());
            preparedStatement.setBoolean(4, book.getIsHide());
            preparedStatement.setString(5, book.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String bookId) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "DELETE FROM book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

}
