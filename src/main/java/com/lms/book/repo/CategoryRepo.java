package com.lms.book.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.book.dal.CategoryDao;
import com.lms.book.entities.Category;
import com.lms.connection.JDBCConnection;

public class CategoryRepo implements CategoryDao {
    @Override
    public Category findById(String id) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM category WHERE genreId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getString("genreId"));
                category.setGenre(resultSet.getString("genre"));
                return category;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM category";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getString("genreId"));
                category.setGenre(resultSet.getString("genre"));
                categories.add(category);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return categories;
    }
}
