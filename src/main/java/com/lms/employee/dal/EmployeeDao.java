package com.lms.employee.dal;
import java.util.List;
import com.lms.employee.model.*;
import com.lms.employee.entities.*;


public interface EmployeeDao {

  public Sheet addSheet(ImportModel newSheet);  

  public List<Sheet> getAllSheets();

  


}