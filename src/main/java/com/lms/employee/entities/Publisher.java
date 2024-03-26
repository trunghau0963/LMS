package com.lms.employee.entities;

public class Publisher {
    String publisherId, publisherName, address;
    boolean isHide;

    public Publisher(String id, String name, String address, boolean isHide) {
        this.publisherId = id;
        this.publisherName = name;
        this.address = address;
        this.isHide = isHide;
    }

    public Publisher(){
        this.publisherId = "";
        this.publisherName = "";
        this.address = "";
        this.isHide = false;
    }

    public void setPublisherName(String name) {
        this.publisherName = name; 
    }

    public void setPublisherId(String id) {
        this.publisherId = id; 
    }

    public void setPublisherAddress(String address) {
        this.address = address; 
    }

    public void setVisible(boolean visible) {
        this.isHide = visible; 
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherAddress() {
        return address;
    }

    public boolean isHide() {
        return isHide;
    }

    @Override
    public String toString(){
        return  publisherId + " " + publisherName +  " " + address + " " + isHide;
    }
}
