package com.lms.exportCRUD.dal;

import java.util.List;

import com.lms.exportCRUD.entities.Category;

public interface CategoryDao {
    public Category findById(String id);

    public List<Category> findAll();
}
