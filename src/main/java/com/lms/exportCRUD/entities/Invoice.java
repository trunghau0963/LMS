package com.lms.exportCRUD.entities;

// CREATE TABLE invoice(
// 	invoiceId CHAR(15) DEFAULT substr(md5(random()::text), 1, 15) PRIMARY KEY,
// 	empId CHAR(16),
// 	memberId CHAR(16) NOT NULL,
// 	saleDate Date NOT NULL,
// 	total FLOAT DEFAULT 0
// );


public class Invoice {
  private String invoiceId, empId, memberId, saleDate;
  private float total;


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

  public void setTotal(float total) {
    this.total = total;
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

  public float getTotal() {
    return total;
  }

  
}
