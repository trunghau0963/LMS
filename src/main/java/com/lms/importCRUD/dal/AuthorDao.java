package com.lms.importCRUD.dal;

import java.util.List;

import com.lms.importCRUD.entities.Author;

public interface AuthorDao {
    public Author findById(String id);

    public List<Author> findAll();
}
