package com.lms.book.dal;

import com.lms.book.entities.Publisher;
import java.util.List;

public interface PublisherDao {
    public Publisher findById(String id);

    public List<Publisher> findAll();
}
