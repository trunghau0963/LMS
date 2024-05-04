package com.lms.exportCRUD.repo;

import java.util.ArrayList;
import java.util.List;

import com.lms.exportCRUD.dal.BookAuthorDao;
import com.lms.exportCRUD.entities.BookAuthor;
import com.lms.connection.JDBCConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookAuthorRepo implements BookAuthorDao {

    Connection connection = null;

    public BookAuthorRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public List<BookAuthor> findByBookId(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "SELECT * FROM author_book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<BookAuthor> bookAuthors = new ArrayList<>();
            while (resultSet.next()) {
                BookAuthor bookAuthor = new BookAuthor(resultSet.getString("bookId"), resultSet.getString("authorId"));
                bookAuthors.add(bookAuthor);
            }
            resultSet.close();
            preparedStatement.close();
            return bookAuthors;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(BookAuthor ba) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "INSERT INTO author_book (authorId, bookId) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ba.getAuthorId());
            preparedStatement.setString(2, ba.getBookId());
            int rowEffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (rowEffected > 0)
                return true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String bookId, String authorId) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "DELETE FROM author_book WHERE bookId = ? AND authorId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, authorId);
            int rowEffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (rowEffected > 0)
                return true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByBookId(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "DELETE FROM author_book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            int rowEffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (rowEffected > 0)
                return true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

}
