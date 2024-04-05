package com.lms.category.dal;

import com.lms.category.entities.Category;
import java.util.List;

public interface CategoryDao {
    public List<Category> findAll();

    public Category findByName(String name);

    public Category findById(String id);

    public boolean add(Category category);

    public boolean update(Category category);

    public boolean delete(String id);
}
