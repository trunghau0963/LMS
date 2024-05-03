package com.lms.sheetCRUD.dal;

import java.util.List;

import com.lms.sheetCRUD.entities.BookAuthor;

public interface BookAuthorDao {
    public List<BookAuthor> findByBookId(String bookId);

    public boolean add(BookAuthor ba);

    public boolean delete(String bookId, String authorId);
}
