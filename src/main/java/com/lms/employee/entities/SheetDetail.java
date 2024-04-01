package com.lms.employee.entities;

public class SheetDetail {

  String sheetId;
  String bookId;
  String quantity;
  String importPrice;

  public String getSheetId() {
    return sheetId;
  }

  public void setSheetId(String sheetId) {
    this.sheetId = sheetId;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getImportPrice() {
    return importPrice;
  }

  public void setImportPrice(String importPrice) {
    this.importPrice = importPrice;
  }

  public SheetDetail(String sheetId, String bookId, String quantity, String importPrice) {
    this.sheetId = sheetId;
    this.bookId = bookId;
    this.quantity = quantity;
    this.importPrice = importPrice;
  } 
  
}
