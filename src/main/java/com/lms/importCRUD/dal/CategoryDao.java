package com.lms.importCRUD.dal;

import java.util.List;

import com.lms.importCRUD.entities.Category;

public interface CategoryDao {
    public Category findById(String id);

    public List<Category> findAll();
}
