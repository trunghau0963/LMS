package com.lms.exportCRUD.dal;

import java.util.List;

import com.lms.exportCRUD.entities.Author;

public interface AuthorDao {
    public Author findById(String id);

    public List<Author> findAll();
}
