package com.lms.employee.service;

import java.util.ArrayList;
import com.lms.employee.dal.AuthorDao;
import com.lms.employee.entities.Author;

public class AuthorService {
    private AuthorDao employeeDao;

    public AuthorService(AuthorDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ArrayList<Author> getListAuthors() {
        return employeeDao.getListAuthors();
    }

    public ArrayList<Author> getListAuthors(String gender, String isHide) {
        return employeeDao.getListAuthors(gender, isHide);
    }

    public ArrayList<Author> getAuthorById(String id, String gender, String isHide) {
        return employeeDao.getAuthorById(id, gender, isHide);
    }

    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide) {
        return employeeDao.getAuthorByName(name, gender, isHide);
    }

    public Author setVisible(String id, boolean isHide) {
        return employeeDao.setVisible(id, isHide);
    }

    public Author addAuthor(String name, String gender, String isHide) {
        return employeeDao.addAuthor(name, gender, isHide);
    }
}
