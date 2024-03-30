package com.lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import com.lms.connection.JDBCConnection;

interface Identifiable {
    int getId();
}

public class Repo<T extends Identifiable> {

    private Connection connection;

    public Repo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    void add(T item) throws SQLException {
        ResultSet resultSet;
        Statement statement = connection.createStatement();
        try {
            resultSet = statement
                    .executeQuery("INSERT INTO " + item.getClass().getSimpleName() + " VALUES (" + item.getId() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void update(T item) {

    }

    void delete(int id) {

    }

    T getById(int id) {
        return null; // Trả về null nếu không tìm thấy
    }

    T getByName(String name) {
        return null; // Trả về null nếu không tìm thấy
    }

    List<T> getAll() {

        return null; // Trả về null nếu không có đối tượng nào
    }

    T existsById(T item) {
        return null; // Trả về null nếu không tìm thấy
    }

    void hide(T item) {

    }

    void show(T item) {

    }
}
