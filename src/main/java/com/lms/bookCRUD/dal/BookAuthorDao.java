package com.lms.bookCRUD.dal;

import java.util.List;

import com.lms.bookCRUD.entities.BookAuthor;

public interface BookAuthorDao {
    public List<BookAuthor> findByBookId(String bookId);

    public boolean add(BookAuthor ba);

    public boolean delete(String bookId, String authorId);
}
