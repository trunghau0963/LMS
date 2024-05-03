package com.lms.exportCRUD.model;

import com.lms.exportCRUD.entities.Author;

public class AuthorModel {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loadFromEntity(Author author) {
        id = author.getId();
        name = author.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
