package com.lms.publisherCRUD.service;
import java.util.ArrayList;

import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.entities.Publisher;

public class PublisherService {
    private PublisherDao pubDao;

    public PublisherService(PublisherDao pubDao) {
        this.pubDao = pubDao;
    }

    public ArrayList<Publisher> getListPublishers() {
        return pubDao.getListPublishers();
    }

    public ArrayList<Publisher> getListPublishers(String isHide){
        return pubDao.getListPublishers(isHide);
    }

    public Publisher setVisible(String id, boolean isHide) {
        return pubDao.setVisible(id, isHide);
    }

    public ArrayList<Publisher> getPublisherById(String id, String isHide) {
        return pubDao.getPublisherById(id, isHide);
    }

    public ArrayList<Publisher> getPublisherByName(String name, String isHide) {
        return pubDao.getPublisherByName(name, isHide);
    }

    public ArrayList<Publisher> getPublisherByAddress(String address, String isHide) {
        return pubDao.getPublisherByAddress(address, isHide);
    }

    public Publisher editInfo(String id, String name, String address, String isHide) {
        return pubDao.editInfo(id, name, address, isHide);
    }

    
    public Publisher addPublisher(String name, String address, String isHide) {
        return pubDao.addPublisher(name, address, isHide);
    }
}
