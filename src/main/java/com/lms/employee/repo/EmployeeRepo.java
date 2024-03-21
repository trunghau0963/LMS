package com.lms.employee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.lms.connection.JDBCConnection;
import com.lms.employee.dal.EmployeeDao;
import com.lms.employee.entities.Author;

public class EmployeeRepo implements EmployeeDao {
    Connection connection = null;

    public EmployeeRepo() {
        connection = JDBCConnection.getJDBConnection();
    }

    @Override
    public ArrayList<Author> getListAuthors() {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author ORDER BY authorName ASC");
            while (resultSet.next()) {
                Author author = new Author();
                author.setAuthorId(resultSet.getString("authorId"));
                author.setAuthorName(resultSet.getString("authorName"));
                author.setAuthorGender(resultSet.getString("gender"));
                author.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                authors.add(author);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author setVisible(String id, boolean isHide) {
        Author author = null;
        try {
            String stmt = "UPDATE author SET isHide = ? WHERE authorId = ?";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setBoolean(1, isHide ? false : true);
            statement.setString(2, id);

            statement.execute();

            stmt = "SELECT * FROM AUTHOR WHERE authorId = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                author = new Author();
                author.setAuthorId(resultSet.getString("authorId"));
                author.setAuthorName(resultSet.getString("authorName"));
                author.setAuthorGender(resultSet.getString("gender"));
                author.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public ArrayList<Author> getAuthorById(String id, String gender, String isHide) {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            boolean convertIsHide;
            
            String stmt = "SELECT * FROM author WHERE authorId ILIKE ?";
            
            stmt += gender != null ? " AND GENDER ILIKE '" + gender + "'" : "";

            if(isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "": "";
            }
            
            stmt += " ORDER BY authorName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + id + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author();
                author.setAuthorId(resultSet.getString("authorId"));
                author.setAuthorName(resultSet.getString("authorName"));
                author.setAuthorGender(resultSet.getString("gender"));
                author.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                authors.add(author);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide) {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            boolean convertIsHide;
            
            String stmt = "SELECT * FROM author WHERE authorName ILIKE ?";
            
            stmt += gender != null ? " AND GENDER ILIKE '" + gender + "'" : "";

            if(isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "": "";
            }
            
            stmt += " ORDER BY authorName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);
            String nameWithWildcards = "%" + name + "%";
            statement.setString(1, nameWithWildcards);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author();
                author.setAuthorId(resultSet.getString("authorId"));
                author.setAuthorName(resultSet.getString("authorName"));
                author.setAuthorGender(resultSet.getString("gender"));
                author.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
                authors.add(author);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author editInfo(String id, String name, String address) {
        // TODO Auto-generated method stub
        return null;
    }
}
