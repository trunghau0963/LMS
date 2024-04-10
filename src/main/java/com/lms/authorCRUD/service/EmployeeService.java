package com.lms.authorCRUD.service;

import com.lms.auth.entities.Employee;
import com.lms.authorCRUD.dal.EmployeeDao;

public class EmployeeService {
    private EmployeeDao authorDao;

    public EmployeeService(EmployeeDao authorDao) {
        this.authorDao = authorDao;
    }

    public Employee editInfo(String empId, String empName, String dob, String pwd, String gender) {
        return authorDao.editInfo(empId, empName, dob, pwd, gender);
    }

    public Employee getInfoEmpById(String id) {
        return authorDao.getInfoEmpById(id);
    }
}
