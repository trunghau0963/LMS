package com.lms.bookCRUD.dal;

import java.util.List;

import com.lms.bookCRUD.entities.Category;

public interface CategoryDao {
    public Category findById(String id);

    public List<Category> findAll();
}
