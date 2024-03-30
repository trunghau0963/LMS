package com.lms.dataSaleCRUD.entities;

public class BookWithRevenue extends Book{
    private float total_revenue;

    public BookWithRevenue() {
        super();
    }

    public BookWithRevenue(String bookId, String publisherId, String title, float salePrice, boolean isHide, float total_revenue) {
        super(bookId, publisherId, title, salePrice, isHide);
        this.total_revenue = total_revenue;
    }

    public void setTotal_revenue(float total_revenue) {
        this.total_revenue = total_revenue;
    }

    public float getTotal_revenue() {
        return total_revenue;
    }

    @Override
    public String toString() {
        return super.getTitle();
    }
}
