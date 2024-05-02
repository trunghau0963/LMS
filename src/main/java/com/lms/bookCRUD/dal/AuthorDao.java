package com.lms.bookCRUD.dal;

import java.util.List;

import com.lms.bookCRUD.entities.Author;

public interface AuthorDao {
    public Author findById(String id);

    public Author findByName(String name);

    public List<Author> findAll();
}
