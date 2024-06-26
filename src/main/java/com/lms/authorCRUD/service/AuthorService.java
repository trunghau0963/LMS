package com.lms.authorCRUD.service;

import java.util.ArrayList;

import com.lms.authorCRUD.dal.AuthorDao;
import com.lms.authorCRUD.entities.Author;
import com.lms.publisherCRUD.entities.Publisher;

public class AuthorService {
    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public ArrayList<Author> getListAuthors() {
        return authorDao.getListAuthors();
    }

    public ArrayList<Author> getListAuthors(String gender, String isHide) {
        return authorDao.getListAuthors(gender, isHide);
    }

    public ArrayList<Author> getAuthorById(String id, String gender, String isHide) {
        return authorDao.getAuthorById(id, gender, isHide);
    }

    public ArrayList<Author> getAuthorByName(String name, String gender, String isHide) {
        return authorDao.getAuthorByName(name, gender, isHide);
    }

    public Author setVisible(String id, boolean isHide) {
        return authorDao.setVisible(id, isHide);
    }

    public Author addAuthor(String name, String gender, String isHide) {
        return authorDao.addAuthor(name, gender, isHide);
    }

    public boolean deleteAuthor(String id) {
        return authorDao.deleteAuthor(id);
    }

    public Author editInfo(String id, String name, String gender, String isHide){
        return authorDao.editInfo(id, name, gender, isHide);
    }

    public ArrayList<Author> SearchByName(String search) {
        ArrayList<Author> result = new ArrayList<Author>();
        ArrayList<Author> all = authorDao.getListAuthors();
        for (Author author : all) {
            if (author.getAuthorName().toLowerCase().contains(search.toLowerCase())) {
                result.add(author);
            }
        }
        return result;
    }
}