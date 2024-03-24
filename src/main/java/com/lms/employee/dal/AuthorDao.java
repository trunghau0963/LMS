package com.lms.employee.dal;

import java.util.ArrayList;
import com.lms.employee.entities.Author;

public interface AuthorDao {
    public ArrayList<Author> getListAuthors();

    public ArrayList<Author> getListAuthors(String gender, String isHide);

    public ArrayList<Author> getAuthorById(String id, String gender, String isHide);

    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide);

    public Author setVisible(String id, boolean isHide);

    public Author editInfo(String id, String name, String address);

    public Author addAuthor(String name, String gender, String isHide);
}