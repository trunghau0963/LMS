package com.lms.importCRUD.dal;

import java.util.List;

import com.lms.importCRUD.entities.BookCategory;

public interface BookCategoryDao {
    public List<BookCategory> findByBookId(String bookId);

    public boolean add(BookCategory bc);

    public boolean delete(String bookId, String genreId);
}
