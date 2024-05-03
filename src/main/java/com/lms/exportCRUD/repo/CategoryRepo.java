package com.lms.exportCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.exportCRUD.dal.CategoryDao;
import com.lms.exportCRUD.entities.Category;
import com.lms.connection.JDBCConnection;

public class CategoryRepo implements CategoryDao {
    Connection connection = null;

    public CategoryRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public Category findById(String id) {
        try {
            connection = JDBCConnection.getJDBCConnection();
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
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM category";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getString("genreId"));
                category.setGenre(resultSet.getString("genre"));
                categories.add(category);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return categories;
    }
}
