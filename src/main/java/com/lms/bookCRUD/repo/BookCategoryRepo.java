package com.lms.bookCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.bookCRUD.dal.BookCategoryDao;
import com.lms.bookCRUD.entities.BookCategory;
import com.lms.connection.JDBCConnection;

public class BookCategoryRepo implements BookCategoryDao {
    Connection connection = null;

    public BookCategoryRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public List<BookCategory> findByBookId(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book_category WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<BookCategory> bookCategories = new ArrayList<>();
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory(resultSet.getString("bookId"),
                        resultSet.getString("genreId"));
                bookCategories.add(bookCategory);
            }
            resultSet.close();
            preparedStatement.close();
            return bookCategories;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(BookCategory bc) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "INSERT INTO book_category (genreId, bookId) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bc.getGenreId());
            preparedStatement.setString(2, bc.getBookId());
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
    public boolean delete(String bookId, String genreId) {
        try {
            connection = JDBCConnection.getJDBCConnection();

            String sql = "DELETE FROM book_category WHERE bookId = ? AND genreId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, genreId);
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
