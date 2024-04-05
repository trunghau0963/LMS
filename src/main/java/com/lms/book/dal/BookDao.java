package com.lms.book.dal;

import com.lms.book.entities.Book;
// import List type
import java.util.List;

public interface BookDao {
    public boolean add(Book book);

    public boolean delete(String bookId);

    public boolean update(Book book);

    public Book findById(String bookId);

    public Book findByTitle(String title);

    public List<Book> findAll();
}
