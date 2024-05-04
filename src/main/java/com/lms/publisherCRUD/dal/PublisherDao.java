package com.lms.publisherCRUD.dal;

import java.util.ArrayList;

import com.lms.publisherCRUD.entities.Publisher;

public interface PublisherDao {
    public ArrayList<Publisher> getListPublishers();
    public ArrayList<Publisher> getListPublishers(String isHide);
    public ArrayList<Publisher> getPublisherById(String id, String isHide);
    public ArrayList<Publisher> getPublisherByName(String name, String isHide);
    public ArrayList<Publisher> getPublisherByAddress(String address, String isHide);
    public Publisher setVisible(String id, boolean isHide);
    public Publisher editInfo(String id, String name, String address, String isHide);

    public Publisher findByName(String name);

    public Publisher addPublisher(String name, String address, String isHide);

    public boolean deletePublisher(String id);
}
