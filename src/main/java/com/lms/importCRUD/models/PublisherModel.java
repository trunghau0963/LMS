package com.lms.importCRUD.models;

import com.lms.importCRUD.entities.Publisher;

public class PublisherModel {
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

    public void loadFromEntity(Publisher publisher) {
        id = publisher.getId();
        name = publisher.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
