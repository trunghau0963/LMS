package com.lms.employee.service;
import com.lms.employee.repo.EmployeeRepo;
import com.lms.employee.model.ImportModel;
import com.lms.employee.entities.Sheet;
import java.util.List;



public class ImportService {
  
  public Sheet addSheet(String importBy, String importDate, Double totalCost) {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    ImportModel newSheet = new ImportModel(importBy, importDate, totalCost);
    return employeeRepo.addSheet(newSheet);
  }


  public List<Sheet> getSheets() {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    return employeeRepo.getAllSheets();
  }


}
