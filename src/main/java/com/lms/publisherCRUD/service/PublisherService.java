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

    public ArrayList<Publisher> getListPublishers(String isHide) {
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

    public ArrayList<Publisher> SearchAll(String search) {
        ArrayList<Publisher> result = new ArrayList<Publisher>();
        ArrayList<Publisher> all = pubDao.getListPublishers();
        for (Publisher publisher : all) {
            if (publisher.getPublisherName().toLowerCase().contains(search.toLowerCase())
                    || publisher.getPublisherAddress().toLowerCase().contains(search.toLowerCase())) {
                result.add(publisher);
            }
        }
        return result;
    }

    public ArrayList<Publisher> SearchByAddress(String search) {
        ArrayList<Publisher> result = new ArrayList<Publisher>();
        ArrayList<Publisher> all = pubDao.getListPublishers();
        for (Publisher publisher : all) {
            if (publisher.getPublisherAddress().toLowerCase().contains(search.toLowerCase())) {
                result.add(publisher);
            }
        }
        return result;
    }

    public ArrayList<Publisher> SearchByName(String search) {
        ArrayList<Publisher> result = new ArrayList<Publisher>();
        ArrayList<Publisher> all = pubDao.getListPublishers();
        for (Publisher publisher : all) {
            if (publisher.getPublisherName().toLowerCase().contains(search.toLowerCase())) {
                result.add(publisher);
            }
        }
        return result;
    }

    public boolean deletePublisher(String id) {
        return pubDao.deletePublisher(id);
    }
}
