package com.lms.categoryCRUD.dal;

import java.util.List;

import com.lms.categoryCRUD.entities.Category;

public interface CategoryDao {
    public List<Category> findAll();

    public Category findByName(String name);

    public Category findById(String id);

    public boolean add(Category category);

    public boolean update(Category category);

    public boolean delete(String id);
}
