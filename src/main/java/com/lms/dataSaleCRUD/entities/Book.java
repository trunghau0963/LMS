package com.lms.dataSaleCRUD.entities;

public class Book {
    private String bookId;
    private String publisherId;
    private String title;
    private float salePrice;
    private boolean isHide;

    public Book() {
        super();
    }

    public Book(String bookId, String publisherId, String title, float salePrice, boolean isHide) {
        super();
        this.bookId = bookId;
        this.publisherId = publisherId;
        this.title = title;
        this.salePrice = salePrice;
        this.isHide = isHide;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public void setIsHide(boolean isHide) {
        this.isHide = isHide;
    }

    public String getBookId() {
        return bookId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getTitle() {
        return title;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public boolean getIsHide() {
        return isHide;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", publisherId=" + publisherId + ", title=" + title + ", salePrice=" + salePrice
                + ", isHide=" + isHide + "]";
    }
}
