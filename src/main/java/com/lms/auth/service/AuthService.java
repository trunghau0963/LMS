package com.lms.auth.service;

import java.util.List;

import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.ModelLogin;
import com.lms.auth.model.ModelRegister;

public class AuthService {
    
    private AuthDao userDao;

    public AuthService(AuthDao userDao) {
        this.userDao = userDao;
    }

    public User register(String userName, String phoneNumber, String pw, String userType){
        ModelRegister newUser = new ModelRegister(userName, phoneNumber, pw, userType);
        return userDao.register(newUser);
    }
    
    public User logIn(String phoneNumber, String pwd, String userType) {
        ModelLogin data = new ModelLogin();
        data.setPhoneNumber(phoneNumber);
        data.setPassword(pwd);
        data.setUserType(userType);
        return userDao.logIn(data);
    }

    public User forgotPasswordAdmin(String phoneNumber) {
        return userDao.forgotPassword(phoneNumber, "Admin");
    }

    public List<Employee> getAllEmployees() {
        return userDao.getAllEmployeeList();
    }

    public User updatePassword(User user, String newPassword) {
        return userDao.updatePassword(user, newPassword);
    }
}
