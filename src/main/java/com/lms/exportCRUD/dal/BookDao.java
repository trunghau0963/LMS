package com.lms.exportCRUD.dal;

// import List type
import java.util.List;

import com.lms.exportCRUD.entities.Book;

public interface BookDao {
    public boolean add(Book book);

    public boolean delete(String bookId);

    public boolean update(Book book);

    public boolean updateQuantity(String bookId, int quantity);

    public Book findById(String bookId);

    public List<Book> findByTitle(String title);
    
    public List<Book> findAll();

    public List<Book> findAvailableBooks();

    public List<Book> findUnavailableBooks();

    public List<Book> find(String column, String keyword);



}
