package com.lms.dataSaleCRUD.entities;

public class EmployeeWithRevenue extends Employee{
    private float total_revenue;

    public EmployeeWithRevenue() {
        super();
    }

    public float getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(float total_revenue) {
        this.total_revenue = total_revenue;
    }
}
