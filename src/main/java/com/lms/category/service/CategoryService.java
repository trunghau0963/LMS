package com.lms.category.service;

import com.lms.category.dal.CategoryDao;
import com.lms.category.entities.Category;
import com.lms.category.model.CategoryModel;
import java.util.List;
import java.util.ArrayList;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryModel> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryModel> categoryModels = new ArrayList<>();
        for (Category category : categories) {
            CategoryModel catModel = new CategoryModel();
            catModel.loadFromEntity(category);
            categoryModels.add(catModel);
        }
        return categoryModels;
    }

    public boolean editCategory(CategoryModel categoryModel) {
        Category category = new Category();
        category.loadFromModel(categoryModel);
        return categoryDao.update(category);
    }

    public boolean addNewCategory(CategoryModel categoryModel) {
        Category category = new Category();
        category.loadFromModel(categoryModel);
        return categoryDao.add(category);
    }

}
