package com.lms.employee.entities;

public class Sheet {
  
  private String sheetId;
  private String responsiblePerson;
  private String sheetDate;
  private Double totalcost;

  public Sheet() {
    
  }

  public void setSheetId(String sheetId) {
    this.sheetId = sheetId;
  }

  public String getSheetId() {
    return sheetId;
  }

  public String getResponsiblePerson() {
    return responsiblePerson;
  }

  public void setResponsiblePerson(String responsiblePerson) {
    this.responsiblePerson = responsiblePerson;
  }

  public String getSheetDate() {
    return sheetDate;
  }

  public void setSheetDate(String sheetDate) {
    this.sheetDate = sheetDate;
  }

  public Double getTotalcost() {
    return totalcost;
  }

  public void setTotalcost(Double totalcost) {
    this.totalcost = totalcost;
  }

  public Sheet(String responsiblePerson, String sheetDate, Double totalcost) {
    this.responsiblePerson = responsiblePerson;
    this.sheetDate = sheetDate;
    this.totalcost = totalcost;
  }

  

}
