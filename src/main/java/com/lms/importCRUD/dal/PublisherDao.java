package com.lms.importCRUD.dal;

import java.util.List;

import com.lms.importCRUD.entities.Publisher;

public interface PublisherDao {
    public Publisher findById(String id);

    public List<Publisher> findAll();
}
