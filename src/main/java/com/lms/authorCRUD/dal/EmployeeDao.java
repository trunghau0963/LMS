package com.lms.authorCRUD.dal;

import com.lms.auth.entities.Employee;

public interface EmployeeDao {
    public Employee getInfoEmpById(String id);

    public Employee editInfo(String empId, String empName, String dob, String pwd, String gender);
}
