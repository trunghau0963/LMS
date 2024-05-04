package com.lms.exportCRUD.dal;

import java.util.List;

import com.lms.exportCRUD.entities.BookAuthor;

public interface BookAuthorDao {
    public List<BookAuthor> findByBookId(String bookId);

    public boolean add(BookAuthor ba);

    public boolean delete(String bookId, String authorId);

    public boolean deleteByBookId(String bookId);
}
