package com.lms.sheetCRUD.dal;

import java.util.List;

import com.lms.sheetCRUD.entities.Author;

public interface AuthorDao {
    public Author findById(String id);

    public List<Author> findAll();
}
