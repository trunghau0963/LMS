package com.lms.dataSaleCRUD.service;

import java.util.List;

import com.lms.auth.entities.User;
import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<BookWithRevenue> getAllBooks() {
        return userDao.getAllBooks();
    }

    public List<BookWithRevenue> getTotalRevenueGroupByBookBetweenDate(String startDate, String endDate) {
        return userDao.getTotalRevenueGroupByBookBetweenDate(startDate, endDate);
    }

    public List<CategoryWithRevenue> getAllCategories() {
        return userDao.getAllCategories();
    }

    public List<CategoryWithRevenue> getTotalRevenueGroupByCategoryBetweenDate(String startDate, String endDate) {
        return userDao.getTotalRevenueGroupByCategoryBetweenDate(startDate, endDate);
    }

    
}
