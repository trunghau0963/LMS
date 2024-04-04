package com.lms.dataSaleCRUD.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.connection.JDBCConnection;
import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;
import com.lms.dataSaleCRUD.entities.CustomerWithRevenue;
import com.lms.dataSaleCRUD.entities.EmployeeWithRevenue;

public class UserRepo implements UserDao {

    public List<BookWithRevenue> getAllBooks() {
        List<BookWithRevenue> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery(
                            "SELECT book.bookId, book.publisherId, book.title, book.salePrice, book.isHide, SUM(invoice_detail.amount) as total_revenue\r\n"
                                    + //
                                    "FROM invoice_detail \r\n" + //
                                    "JOIN book ON invoice_detail.bookId = book.bookId\r\n" + //
                                    "GROUP BY book.bookId, book.publisherId, book.title, book.salePrice, book.isHide\r\n"
                                    + //
                                    "ORDER BY total_revenue DESC;");

            while (resultSet.next()) {
                BookWithRevenue book = new BookWithRevenue();
                book.setTitle(resultSet.getString("title"));
                book.setPublisherId(resultSet.getString("publisherId"));
                book.setBookId(resultSet.getString("bookId"));
                book.setSalePrice(resultSet.getFloat("salePrice"));
                book.setIsHide(resultSet.getBoolean("isHide"));
                book.setTotal_revenue(resultSet.getFloat("total_revenue"));

                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }

    public List<BookWithRevenue> getTotalRevenueGroupByBookBetweenDate(String startDate, String endDate) {
        List<BookWithRevenue> books = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCConnection.getJDBConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id.bookId AS book_id, b.title AS book_title, SUM(id.amount) AS total_revenue " +
                            "FROM invoice_detail id " +
                            "JOIN invoice i ON i.invoiceId = id.invoiceId " +
                            "JOIN book b ON b.bookId = id.bookId " +
                            "WHERE i.saleDate BETWEEN ? AND ? " +
                            "GROUP BY id.bookId, b.title");

            // Convert the String dates to java.sql.Date
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);

            statement.setDate(1, sqlStartDate);
            statement.setDate(2, sqlEndDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookWithRevenue book = new BookWithRevenue();
                book.setBookId(resultSet.getString("book_id"));
                book.setTitle(resultSet.getString("book_title"));
                book.setTotal_revenue(resultSet.getFloat("total_revenue"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return books;
    }

    public List<CategoryWithRevenue> getAllCategories() {
        List<CategoryWithRevenue> categories = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT c.genreId, c.genre, SUM(id.amount) AS \"total_Revenue\"\r\n" + //
                            "FROM category c\r\n" + //
                            "JOIN book_category bc ON c.genreId = bc.genreId\r\n" + //
                            "JOIN book b ON bc.bookId = b.bookId\r\n" + //
                            "JOIN invoice_detail id ON b.bookId = id.bookId\r\n" + //
                            "GROUP BY c.genreId, c.genre;");

            while (resultSet.next()) {
                CategoryWithRevenue category = new CategoryWithRevenue();
                category.setGenreId(resultSet.getString("genreId"));
                category.setGenre(resultSet.getString("genre"));
                category.setTotal_revenue(resultSet.getFloat("total_Revenue"));

                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return categories;
    }

    public List<CategoryWithRevenue> getTotalRevenueGroupByCategoryBetweenDate(String startDate, String endDate) {
        List<CategoryWithRevenue> categories = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCConnection.getJDBConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.genreId AS genreId, c.genre AS genre, SUM(id.amount) AS total_Revenue\r\n" + //
                            "FROM invoice_detail id\r\n" + //
                            "JOIN invoice i ON i.invoiceId = id.invoiceId\r\n" + //
                            "JOIN book b ON b.bookId = id.bookId\r\n" + //
                            "JOIN book_category bc on b.bookId = bc.bookId\r\n" + //
                            "JOIN category c ON c.genreId = bc.genreId\r\n" + //
                            "WHERE i.saleDate BETWEEN ? AND ?\r\n" + //
                            "GROUP BY c.genreId, c.genre");

            // Convert the String dates to java.sql.Date
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);

            statement.setDate(1, sqlStartDate);
            statement.setDate(2, sqlEndDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CategoryWithRevenue category = new CategoryWithRevenue();
                category.setGenreId(resultSet.getString("genreId"));
                category.setGenre(resultSet.getString("genre"));
                category.setTotal_revenue(resultSet.getFloat("total_Revenue"));

                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return categories;
    }

    public List<CustomerWithRevenue> getAllCustomers() {
        List<CustomerWithRevenue> customers = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCConnection.getJDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery(
                            "SELECT member.memberId as customerId, member.memberName as customerName, SUM(invoice_detail.amount) as total_revenue\r\n"
                                    + //
                                    "FROM member\r\n" + //
                                    "JOIN invoice ON member.memberId = invoice.memberId\r\n" + //
                                    "JOIN invoice_detail ON invoice.invoiceId = invoice_detail.invoiceId\r\n" + //
                                    "GROUP BY member.memberId, member.memberName;");

            while (resultSet.next()) {
                CustomerWithRevenue customer = new CustomerWithRevenue();
                customer.setId(resultSet.getString("customerId"));
                customer.setName(resultSet.getString("customerName"));
                customer.setTotal_revenue(resultSet.getFloat("total_revenue"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return customers;
    }

    public List<CustomerWithRevenue> getTotalRevenueGroupByCustomerBetweenDate(String startDate, String endDate) {
        List<CustomerWithRevenue> customers = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCConnection.getJDBConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT m.memberId AS customerId, m.memberName AS customerName, SUM(id.amount) AS total_revenue\r\n" + //
                            "FROM invoice_detail id\r\n" + //
                            "JOIN invoice i ON i.invoiceId = id.invoiceId\r\n" + //
                            "JOIN member m ON m.memberId = i.memberId\r\n" + //
                            "WHERE i.saleDate BETWEEN ? AND ?\r\n" + //
                            "GROUP BY m.memberId, m.memberName");

            // Convert the String dates to java.sql.Date
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);

            statement.setDate(1, sqlStartDate);
            statement.setDate(2, sqlEndDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CustomerWithRevenue customer = new CustomerWithRevenue();
                customer.setId(resultSet.getString("customerId"));
                customer.setName(resultSet.getString("customerName"));
                customer.setTotal_revenue(resultSet.getFloat("total_revenue"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Connection to PostgreSQL failed.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return customers;
    }

    public List<EmployeeWithRevenue> getAllEmployees() {
        return null;
    }

    public List<EmployeeWithRevenue> getTotalRevenueGroupByEmployeeBetweenDate(String startDate, String endDate) {
        return null;
    }

}
