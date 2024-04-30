package com.lms.importCRUD.entities;

import com.lms.importCRUD.models.BookModel;

public class Book {
    private String id;
    private Integer edition;
    private String title;
    private String publisherId;
    private Float salePrice;
    private Integer quantity;
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

    public Integer getEdition() {
        return edition;
    }

    public Integer getQuantity() {
        return quantity;
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

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        id = book.getId();
        title = book.getTitle();
        edition = book.getEdition();
        quantity = book.getQuantity();
        publisherId = book.getPublisher().getId();
        salePrice = book.getSalePrice();
        isHide = book.getIsHide();
    }

}
