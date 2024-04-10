package com.lms.bookCRUD.dal;

import java.util.List;

import com.lms.bookCRUD.entities.Publisher;

public interface PublisherDao {
    public Publisher findById(String id);

    public List<Publisher> findAll();
}
