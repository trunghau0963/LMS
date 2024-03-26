package com.lms.employee.dal;

import java.util.ArrayList;

import com.lms.employee.entities.Publisher;

public interface PublisherDao {
    public ArrayList<Publisher> getListPublishers();
    public ArrayList<Publisher> getListPublishers(String isHide);
    public ArrayList<Publisher> getPublisherById(String id, String isHide);
    public ArrayList<Publisher> getPublisherByName(String name, String isHide);
    public ArrayList<Publisher> getPublisherByAddress(String address, String isHide);
    public Publisher setVisible(String id, boolean isHide);
    public Publisher editInfo(String id, String name, String address, String isHide);

    public Publisher addPublisher(String name, String address, String isHide);
}
