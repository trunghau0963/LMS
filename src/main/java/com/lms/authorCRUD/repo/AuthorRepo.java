package com.lms.authorCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.lms.authorCRUD.dal.AuthorDao;
import com.lms.authorCRUD.entities.Author;
import com.lms.connection.JDBCConnection;

public class AuthorRepo implements AuthorDao {
    Connection connection = null;

    public AuthorRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    @Override
    public ArrayList<Author> getListAuthors() {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            connection = JDBCConnection.getJDBCConnection();

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
    public ArrayList<Author> getListAuthors(String gender, String isHide) {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "SELECT * FROM author";
            stmt += gender != null ? " Where GENDER ILIKE '" + gender + "'" : "";

            if (isHide != null && gender != null) {
                boolean convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " And isHide = " + convertIsHide + "" : "";
            } else if (isHide != null && gender == null) {
                boolean convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " Where isHide = " + convertIsHide + "" : "";
            }

            stmt += " ORDER BY authorName ASC";

            PreparedStatement statement = connection.prepareStatement(stmt);

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
    public Author setVisible(String id, boolean isHide) {
        Author author = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

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
            connection = JDBCConnection.getJDBCConnection();

            boolean convertIsHide;

            String stmt = "SELECT * FROM author WHERE authorId ILIKE ?";

            stmt += gender != null ? " AND GENDER ILIKE '" + gender + "'" : "";

            if (isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "" : "";
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
            connection = JDBCConnection.getJDBCConnection();
            boolean convertIsHide;

            String stmt = "SELECT * FROM author WHERE authorName ILIKE ?";

            stmt += gender != null ? " AND GENDER ILIKE '" + gender + "'" : "";

            if (isHide != null) {
                convertIsHide = isHide.equals("Hide") ? true : false;
                stmt += isHide != null ? " AND isHide = " + convertIsHide + "" : "";
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
    public Author addAuthor(String name, String gender, String isHide) {
        Author author = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "INSERT INTO author (authorName, gender, isHide) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, gender.toLowerCase());
            statement.setBoolean(3, isHide.equals("Hide") ? true : false);

            statement.execute();

            stmt = "SELECT * FROM AUTHOR WHERE authorName = ? and gender = ?";
            statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, gender);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                author = new Author();
                author.setAuthorId(resultSet.getString("authorId"));
                author.setAuthorName(resultSet.getString("authorName"));
                author.setAuthorGender(resultSet.getString("gender"));
                author.setVisible(resultSet.getString("isHide").equals("t") ? true : false);
            }

            JOptionPane.showMessageDialog(null, "Add successfully");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public Author editInfo(String id, String name, String gender, String isHide) {
        Author author = null;
        try {
            connection = JDBCConnection.getJDBCConnection();

            String stmt = "Update author set authorName = ?, gender = ?, isHide = ? Where authorId = ?";
            PreparedStatement statement = connection.prepareStatement(stmt);
            statement.setString(1, name);
            statement.setString(2, gender.toLowerCase());
            statement.setBoolean(3, isHide.equals("Hide") ? true : false);
            statement.setString(4, id);

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

            JOptionPane.showMessageDialog(null, "Edit info successfully");
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        }
        return author;
    }
}
