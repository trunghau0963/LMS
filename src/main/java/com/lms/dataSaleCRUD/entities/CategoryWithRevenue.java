package com.lms.dataSaleCRUD.entities;

public class CategoryWithRevenue extends Category{
    private float total_revenue;

    public CategoryWithRevenue() {
        super();
    }

    public CategoryWithRevenue(String genre, String genreId, float total_revenue) {
        super(genre, genreId);
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
        return super.getGenre();
    }
}
