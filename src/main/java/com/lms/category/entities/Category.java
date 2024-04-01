package com.lms.category.entities;

import com.lms.category.model.CategoryModel;

public class Category {
    private String id;
    private String genre;

    public String getGenre() {
        return genre;
    }

    public String getId() {
        return id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void loadFromModel(CategoryModel categoryModel) {
        id = categoryModel.getId();
        genre = categoryModel.getGenre();
    }
}
