package com.lms.book.dal;

import java.util.List;

import com.lms.book.entities.Author;

public interface AuthorDao {
    public Author findById(String id);

    public List<Author> findAll();
}
