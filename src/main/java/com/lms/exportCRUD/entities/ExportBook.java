package com.lms.exportCRUD.entities;

public class ExportBook {
  
  private String id;
  private int quantity;
  private float exportPrice;

  public ExportBook() {
  }

  public ExportBook(String id, int quantity, float exportPrice) {
    this.id = id;
    this.quantity = quantity;
    this.exportPrice = exportPrice;
  }

  public String getId() {
    return id;
  }

  public int getQuantity() {
    return quantity;
  }

  public float getExportPrice() {
    return exportPrice;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setExportPrice(float exportPrice) {
    this.exportPrice = exportPrice;
  }


}
