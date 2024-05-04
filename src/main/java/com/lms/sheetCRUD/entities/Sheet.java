package com.lms.sheetCRUD.entities;

public class Sheet {
    private String sheetId, responsible, date;
    private float totalCost;

    public Sheet() {
    }

    public Sheet(String sheetId, String responsible, String date, float totalCost) {
        this.sheetId = sheetId;
        this.responsible = responsible;
        this.date = date;
        this.totalCost = totalCost;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getSheetId() {
        return this.sheetId;
    }

    public String getResponsible() {
        return this.responsible;
    }

    public String getDate() {
        return this.date;
    }

    public float getTotalCost() {
        return this.totalCost;
    }
}
