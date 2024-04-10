package com.lms.bookCRUD.dal;

// import List type
import java.util.List;

import com.lms.bookCRUD.entities.Book;

public interface BookDao {
    public boolean add(Book book);

    public boolean delete(String bookId);

    public boolean update(Book book);

    public Book findById(String bookId);

    public Book findByTitle(String title);

    public List<Book> findAll();
}
