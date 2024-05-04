package com.lms.categoryCRUD.model;

import com.lms.categoryCRUD.entities.Category;

public class CategoryModel {
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

    public void loadFromEntity(Category category) {
        id = category.getId();
        genre = category.getGenre();
    }
}
