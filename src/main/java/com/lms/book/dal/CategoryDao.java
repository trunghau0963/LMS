package com.lms.book.dal;

import com.lms.book.entities.Category;
import java.util.List;

public interface CategoryDao {
    public Category findById(String id);

    public List<Category> findAll();
}
