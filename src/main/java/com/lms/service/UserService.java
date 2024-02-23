package com.lms.service;

import java.util.List;

import com.lms.connection.UserDao;
import com.lms.entities.User;

public class UserService {
        private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getAllEmployees() {
        return userDao.getAllEmployeeList();
    }
}
