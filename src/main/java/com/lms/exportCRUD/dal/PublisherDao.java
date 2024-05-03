package com.lms.exportCRUD.dal;

import java.util.List;

import com.lms.exportCRUD.entities.Publisher;

public interface PublisherDao {
    public Publisher findById(String id);

    public List<Publisher> findAll();
}
