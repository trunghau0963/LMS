package com.lms.employee.service;

import java.util.ArrayList;
import com.lms.employee.dal.EmployeeDao;
import com.lms.employee.entities.Author;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ArrayList<Author> getListAuthors() {
        return employeeDao.getListAuthors();
    }

    public ArrayList<Author> getAuthorById(String id, String gender, String isHide){
        return employeeDao.getAuthorById(id, gender, isHide);
    }

    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide){
        return employeeDao.getAuthorByName(name, gender, isHide);
    }

    public Author setVisible(String id, boolean isHide) {
        return employeeDao.setVisible(id, isHide);
    }
}
