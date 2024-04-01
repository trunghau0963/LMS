package com.lms.book.entities;

import com.lms.book.model.BookModel;

public class Book {
    private String id;
    private String title;
    private String publisherId;
    private Float salePrice;
    private Boolean isHide;

    public Book() {
        id = null;
        title = null;
        publisherId = null;
        salePrice = 0.0f;
        isHide = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public Boolean getIsHide() {
        return isHide;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public void setIsHide(boolean isHide) {
        this.isHide = isHide;
    }

    public void loadFromModel(BookModel book) {
        title = book.getTitle();
        publisherId = book.getPublisher().getId();
        salePrice = book.getSalePrice();
        isHide = book.getIsHide();
    }

}
