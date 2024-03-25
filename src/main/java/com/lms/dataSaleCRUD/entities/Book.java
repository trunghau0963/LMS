package com.lms.dataSaleCRUD.entities;

public class Book {
    private String bookId;
    private String publisherId;
    private String title;
    private float salePrice;
    private boolean isHide;
    private float total_revenue;

    public Book() {
        super();
    }

    public Book(String bookId, String publisherId, String title, float salePrice, boolean isHide, float total_revenue) {
        super();
        this.bookId = bookId;
        this.publisherId = publisherId;
        this.title = title;
        this.salePrice = salePrice;
        this.isHide = isHide;
        this.total_revenue = total_revenue;
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

    public void setTotal_revenue(float total_revenue) {
        this.total_revenue = total_revenue;
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

    public float getTotal_revenue() {
        return total_revenue;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", publisherId=" + publisherId + ", title=" + title + ", salePrice=" + salePrice
                + ", isHide=" + isHide + "]";
    }

    public static String getInitials(String str) {
        String[] words = str.split(" ");
        StringBuilder initials = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.charAt(0));
            }
        }

        return initials.toString().toUpperCase();
    }
}
