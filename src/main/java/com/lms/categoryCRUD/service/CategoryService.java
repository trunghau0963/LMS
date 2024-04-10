package com.lms.categoryCRUD.service;

import java.util.List;

import com.lms.categoryCRUD.dal.CategoryDao;
import com.lms.categoryCRUD.entities.Category;
import com.lms.categoryCRUD.model.CategoryModel;

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

    public CategoryModel getCategoryByName(String name) {
        Category category = categoryDao.findByName(name);
        if (category == null) {
            return null;
        }
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.loadFromEntity(category);
        return categoryModel;
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
