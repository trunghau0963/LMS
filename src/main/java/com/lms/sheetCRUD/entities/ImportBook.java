package com.lms.sheetCRUD.entities;

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

    @Override
    public String toString() {
        return "ImportBook{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", importPrice=" + importPrice +
                '}';
    }
}