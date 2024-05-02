package com.lms.importCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.importCRUD.dal.PublisherDao;
import com.lms.importCRUD.entities.Publisher;
import com.lms.connection.JDBCConnection;

public class PublisherRepo implements PublisherDao {
    Connection connection = null;

    public PublisherRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public Publisher findById(String id) {
        try {
            connection = JDBCConnection.getJDBCConnection();
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
        try {
            connection = JDBCConnection.getJDBCConnection();
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
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return publishers;
    }

    public static PublisherDao getInstance() {
        return new PublisherRepo();
    }
}
