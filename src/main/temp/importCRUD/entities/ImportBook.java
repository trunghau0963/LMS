package com.lms.importCRUD.entities;

public class ImportBook {
    private String id;
    private int quantity;
    private float importPrice;

    public ImportBook(String id, int quantity, float importPrice) {
        this.id = id;
        this.quantity = quantity;
        this.importPrice = importPrice;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }
}