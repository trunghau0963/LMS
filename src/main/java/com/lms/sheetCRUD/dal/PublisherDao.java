package com.lms.sheetCRUD.dal;

import java.util.List;

import com.lms.sheetCRUD.entities.Publisher;

public interface PublisherDao {
    public Publisher findById(String id);

    public List<Publisher> findAll();
}
