package com.lms.authorCRUD.dal;

import java.util.ArrayList;

import com.lms.authorCRUD.entities.Author;

public interface AuthorDao {
    public ArrayList<Author> getListAuthors();
    public ArrayList<Author> getListAuthors(String gender, String isHide);
    public ArrayList<Author> getAuthorById(String id, String gender, String isHide);
    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide);
    public Author setVisible(String id, boolean isHide);
    public Author editInfo(String id, String name, String gender, String isHide);

    public Author addAuthor(String name, String gender, String isHide);

    public boolean deleteAuthor(String id);
}