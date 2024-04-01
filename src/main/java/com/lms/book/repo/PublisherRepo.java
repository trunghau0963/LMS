package com.lms.book.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.book.dal.PublisherDao;
import com.lms.book.entities.Publisher;
import com.lms.connection.JDBCConnection;

public class PublisherRepo implements PublisherDao {
    @Override
    public Publisher findById(String id) {
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM publisher WHERE publisherId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(resultSet.getString("publisherId"));
                publisher.setName(resultSet.getString("publisherName"));
                publisher.setAddress(resultSet.getString("publisherAddress"));
                publisher.setHide(resultSet.getBoolean("isHide"));
                return publisher;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Publisher> findAll() {
        List<Publisher> publishers = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBConnection()) {
            String sql = "SELECT * FROM publisher";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(resultSet.getString("publisherId"));
                publisher.setName(resultSet.getString("publisherName"));
                publisher.setAddress(resultSet.getString("publisherAddress"));
                publisher.setHide(resultSet.getBoolean("isHide"));
                publishers.add(publisher);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return publishers;
    }
}
