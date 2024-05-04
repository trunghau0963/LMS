package com.lms.exportCRUD.dal;

import java.util.List;

import com.lms.exportCRUD.entities.BookCategory;

public interface BookCategoryDao {
    public List<BookCategory> findByBookId(String bookId);

    public boolean add(BookCategory bc);

    public boolean delete(String bookId, String genreId);

    public boolean deleteByBookId(String bookId);
}
