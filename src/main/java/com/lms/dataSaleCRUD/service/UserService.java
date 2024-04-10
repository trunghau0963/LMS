package com.lms.dataSaleCRUD.service;

import java.util.List;


import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;
import com.lms.dataSaleCRUD.entities.CustomerWithRevenue;
import com.lms.dataSaleCRUD.entities.EmployeeWithRevenue;

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

    public List<CustomerWithRevenue> getAllCustomers() {
        return userDao.getAllCustomers();
    }

    public List<CustomerWithRevenue> getTotalRevenueGroupByCustomerBetweenDate(String startDate, String endDate) {
        return userDao.getTotalRevenueGroupByCustomerBetweenDate(startDate, endDate);
    }

    public List<EmployeeWithRevenue> getAllEmployees() {
        return userDao.getAllEmployees();
    }

    public List<EmployeeWithRevenue> getTotalRevenueGroupByEmployeeBetweenDate(String startDate, String endDate) {
        return userDao.getTotalRevenueGroupByEmployeeBetweenDate(startDate, endDate);
    }

    
}
