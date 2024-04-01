package com.lms.book.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.book.dal.AuthorDao;
import com.lms.book.entities.Author;
import com.lms.connection.JDBCConnection;

public class AuthorRepo implements AuthorDao {
    @Override
    public Author findById(String id) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM author WHERE authorId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getString("authorId"));
                author.setName(resultSet.getString("authorName"));
                author.setGender(resultSet.getString("gender"));
                author.setHide(resultSet.getBoolean("isHide"));
                return author;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM author";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getString("authorId"));
                author.setName(resultSet.getString("authorName"));
                author.setGender(resultSet.getString("gender"));
                author.setHide(resultSet.getBoolean("isHide"));
                authors.add(author);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return authors;
    }
}
