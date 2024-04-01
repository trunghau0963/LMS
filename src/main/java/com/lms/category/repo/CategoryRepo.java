package com.lms.category.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.category.dal.CategoryDao;
import com.lms.category.entities.Category;
import com.lms.connection.JDBCConnection;

public class CategoryRepo implements CategoryDao {
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
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category findById(String id) {
        Category category = new Category();
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM category WHERE genreId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(id);
                category.setGenre(resultSet.getString("genre"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return category;
    }

    @Override
    public boolean add(Category category) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "INSERT INTO category (genre) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getGenre());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "UPDATE category SET genre = ? WHERE genreId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getGenre());
            preparedStatement.setString(2, category.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "DELETE FROM category WHERE genreId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

}
