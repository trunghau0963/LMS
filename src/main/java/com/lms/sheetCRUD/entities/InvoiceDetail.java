package com.lms.sheetCRUD.entities;

// CREATE TABLE invoice_detail(
// 	invoiceId CHAR(15),
// 	bookId CHAR(14),
// 	quantity INT,
// 	cost FLOAT,
// 	PRIMARY KEY (invoiceId, bookId)
// );


import java.util.List;

public class InvoiceDetail {
  
  private String invoiceId, bookId;
  private int quantity;
  private float cost;
  private List<ExportBook> books;


  public InvoiceDetail() {
  }

  public InvoiceDetail(String invoiceId, List<ExportBook> listBook) {
    this.invoiceId = invoiceId;
    this.books = listBook;
  }
  public InvoiceDetail(String invoiceId, String bookId, int quantity, float cost) {
    this.invoiceId = invoiceId;
    this.bookId = bookId;
    this.quantity = quantity;
    this.cost = cost;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public String getInvoiceId() {
    return invoiceId;
  }

  public String getBookId() {
    return bookId;
  }

  public int getQuantity() {
    return quantity;
  }

  public java.util.List<ExportBook> getBooks() {
    return books;
  }

  public float getCost() {
    return cost;
  }

}
