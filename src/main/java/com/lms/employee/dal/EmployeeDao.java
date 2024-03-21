package com.lms.employee.dal;

import java.util.ArrayList;
import com.lms.employee.entities.Author;

public interface EmployeeDao {
    public ArrayList<Author> getListAuthors();

    public ArrayList<Author> getAuthorById(String id, String gender, String isHide);
    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide);


    public Author setVisible(String id, boolean isHide);

    public Author editInfo(String id, String name, String address);
}