package com.lms.employee.model;

public class ImportModel {
  
  String importDate;
  String importBy;
  Double totalCost;

  public String getImportDate() {
    return importDate;
  }

  public void setImportDate(String importDate) {
    this.importDate = importDate;
  }

  public String getImportBy() {
    return importBy;
  }

  public void setImportBy(String importBy) {
    this.importBy = importBy;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }
  
  public ImportModel(String importDate, String importBy, Double totalCost) {
    this.importDate = importDate;
    this.importBy = importBy;
    this.totalCost = totalCost;
  }


}
