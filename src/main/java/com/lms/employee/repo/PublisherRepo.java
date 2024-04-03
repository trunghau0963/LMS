package com.lms.employee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.lms.connection.JDBCConnection;
import com.lms.employee.dal.PublisherDao;
import com.lms.employee.entities.Publisher;

public class PublisherRepo implements PublisherDao {
    Connection connection = null;

    public PublisherRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public ArrayList<Publisher> getListPublishers() {
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM publisher ORDER BY publisherName ASC");
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public ArrayList<Publisher> getListPublishers(String isHide){
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "SELECT * FROM publisher";

            if(isHide != null){
                boolean convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " Where isHide = " + convertIsHide + "" : "";
            }
            
            stmt += " ORDER BY publisherName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public Publisher setVisible(String id, boolean isHide) {
        Publisher publisher = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "UPDATE publisher SET isHide = ? WHERE publisherId = ?";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setBoolean(1, isHide ? false : true);
            statement.setString(2, id);

            statement.execute();

            stmt = "SELECT * FROM Publisher WHERE publisherId = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publisher;
    }

    @Override
    public ArrayList<Publisher> getPublisherById(String id, String isHide) {
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            boolean convertIsHide;

            String stmt = "SELECT * FROM publisher WHERE publisherId ILIKE ?";

            if (isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "" : "";
            }

            stmt += " ORDER BY publisherName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + id + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public ArrayList<Publisher> getPublisherByName(String name, String isHide) {
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            boolean convertIsHide;

            String stmt = "SELECT * FROM Publisher WHERE publisherName ILIKE ?";


            if (isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "" : "";
            }

            stmt += " ORDER BY PublisherName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + name + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public ArrayList<Publisher> getPublisherByAddress(String address, String isHide) {
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            boolean convertIsHide;

            String stmt = "SELECT * FROM Publisher WHERE publisherAddress ILIKE ?";


            if (isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "" : "";
            }

            stmt += " ORDER BY PublisherName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + address + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public Publisher editInfo(String id, String name, String address, String isHide) {
        Publisher publisher = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "Update Publisher set publisherName = ?, publisherAddress = ?, isHide = ? Where publisherId = ?";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, address.toLowerCase());
            statement.setBoolean(3, isHide.equals("Hide") ? true : false);
            statement.setString(4, id);

            statement.execute();

            stmt = "SELECT * FROM Publisher WHERE publisherId = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
            }

            JOptionPane.showMessageDialog(null, "Edit info successfully");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publisher;
    }

    @Override
    public Publisher addPublisher(String name, String address, String isHide) {
        Publisher publisher = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "INSERT INTO publisher (publisherName, publisherAddress, isHide) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setBoolean(3, isHide.equals("Hide") ? true : false);

            statement.execute();

            stmt = "SELECT * FROM publisher WHERE publisherName = ? and publisherAddress = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, address);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                publisher = new Publisher();
                publisher.setPublisherId(resultSet.getString("publisherId"));
                publisher.setPublisherName(resultSet.getString("publisherName"));
                publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
                publisher.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
            }

            JOptionPane.showMessageDialog(null, "Add successfull");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return publisher;
    }
}
