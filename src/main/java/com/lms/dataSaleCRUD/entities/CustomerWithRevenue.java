package com.lms.dataSaleCRUD.entities;

public class CustomerWithRevenue extends Customer{
    private float total_revenue;

    public CustomerWithRevenue() {
        super();
    }

    public void setTotal_revenue(float total_revenue) {
        this.total_revenue = total_revenue;
    }

    public float getTotal_revenue() {
        return total_revenue;
    }

}
