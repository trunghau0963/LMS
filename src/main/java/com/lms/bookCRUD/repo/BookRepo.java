package com.lms.bookCRUD.repo;

import com.lms.bookCRUD.dal.BookDao;
import com.lms.bookCRUD.entities.Book;
import com.lms.connection.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements BookDao {
    Connection connection = null;

    public BookRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public Book findById(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
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
    public List<Book> findByTitle(String title) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book WHERE title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
            resultSet.close();
            preparedStatement.close();
            return books;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }

    public List<Book> findAvailableBooks() {
        List<Book> books = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book WHERE quantity > 0 AND isHide = false";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }

    public List<Book> findUnavailableBooks() {
        List<Book> books = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book WHERE quantity = 0 OR isHide = true";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }

    public boolean isHide(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT isHide FROM book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("isHide");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(Book newBook) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO book (title, publisherId, salePrice, bookEdition, quantity, isHide) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getPublisherId());
            preparedStatement.setFloat(3, newBook.getSalePrice());
            preparedStatement.setInt(4, newBook.getEdition());
            preparedStatement.setInt(5, newBook.getQuantity());
            preparedStatement.setBoolean(6, newBook.getIsHide());
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE book SET publisherId = ?, title = ?, isHide = ?, bookEdition = ? WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getPublisherId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setBoolean(3, book.getIsHide());
            preparedStatement.setInt(4, book.getEdition());
            preparedStatement.setString(5, book.getId());
            System.out.println(preparedStatement);
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String bookId) {
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "DELETE FROM book WHERE bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookId);
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> find(String column, String keyword) {
        List<Book> books = new ArrayList<>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM book WHERE ? LIKE ?";
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, column);
            preparedStatement.setString(2, "%" + keyword + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setEdition(resultSet.getInt("bookEdition"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                books.add(book);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }

}
