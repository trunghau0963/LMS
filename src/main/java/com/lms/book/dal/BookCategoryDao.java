package com.lms.book.dal;

import java.util.List;

import com.lms.book.entities.BookCategory;

public interface BookCategoryDao {
    public List<BookCategory> findByBookId(String bookId);

    public boolean add(BookCategory bc);

    public boolean delete(String bookId, String genreId);
}
