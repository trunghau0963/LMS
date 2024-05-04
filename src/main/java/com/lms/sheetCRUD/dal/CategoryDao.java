package com.lms.sheetCRUD.dal;

import java.util.List;

import com.lms.sheetCRUD.entities.Category;

public interface CategoryDao {
    public Category findById(String id);

    public List<Category> findAll();
}
