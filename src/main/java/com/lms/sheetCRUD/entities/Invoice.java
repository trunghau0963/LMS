package com.lms.sheetCRUD.entities;

// CREATE TABLE invoice(
// 	invoiceId CHAR(15) DEFAULT substr(md5(random()::text), 1, 15) PRIMARY KEY,
// 	empId CHAR(16),
// 	memberId CHAR(16) NOT NULL,
// 	saleDate Date NOT NULL,
// 	total FLOAT DEFAULT 0
// );


public class Invoice {
  private String invoiceId, empId, memberId, saleDate;
  private double total;

  public Invoice() {
  }


  public Invoice(String invoiceId, String empId, String memberId, String saleDate, float total) {
    this.invoiceId = invoiceId;
    this.empId = empId;
    this.memberId = memberId;
    this.saleDate = saleDate;
    this.total = total;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public void setSaleDate(String saleDate) {
    this.saleDate = saleDate;
  }

  public void setTotal(double d) {
    this.total = d;
  }

  public String getInvoiceId() {
    return invoiceId;
  }

  public String getEmpId() {
    return empId;
  }

  public String getMemberId() {
    return memberId;
  }

  public String getSaleDate() {
    return saleDate;
  }

  public double getTotal() {
    return total;
  }

  
}
