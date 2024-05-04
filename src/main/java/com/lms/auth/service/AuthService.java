package com.lms.auth.service;

import java.util.List;

import com.lms.auth.controller.BCrypt;
import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.LoginModel;
import com.lms.auth.model.RegisterModel;

public class AuthService {

    private AuthDao userDao;

    public AuthService(AuthDao userDao) {
        this.userDao = userDao;
    }

    public User register(String userName, String phoneNumber, String pw, String userType) {
        String hashed = BCrypt.hashpw(pw, BCrypt.gensalt(12));
        RegisterModel newUser = new RegisterModel(userName, phoneNumber, hashed, userType);
        return userDao.register(newUser);
    }

    public User logIn(String phoneNumber, String pwd, String userType) {
        // LoginModel data = new LoginModel();
        // data.setPhoneNumber(phoneNumber);
        // data.setPassword(pwd);
        // data.setUserType(userType);
        if (userType.equals("Admin")) {
            Admin acc = (Admin) forgotPasswordAdmin(phoneNumber);
            if (BCrypt.checkpw(pwd, acc.getPwd())) {
                return acc;
            } else {
                return null;
            }
        } else {
            Employee acc = (Employee) getUserByPhoneNumber(phoneNumber, userType);
            if (BCrypt.checkpw(pwd, acc.getPwd())) {
                return acc;
            } else {
                return null;
            }
        }
    }

    public User forgotPasswordAdmin(String phoneNumber) {
        return userDao.forgotPassword(phoneNumber, "Admin");
    }

    public User forgotPassworEmp(String phoneNumber) {
        return userDao.forgotPassword(phoneNumber, "Employee");
    }

    public List<Employee> getAllEmployees() {
        return userDao.getAllEmployeeList();
    }

    public User updatePassword(User user, String newPassword) {
        String hashed = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
        return userDao.updatePassword(user, hashed);
    }

    public User getUserByPhoneNumber(String phoneNumber, String userType) {
        return userDao.getUserByPhoneNumber(phoneNumber, userType);
    }
}
