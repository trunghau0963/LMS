package com.lms.auth.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.LoginModel;
import com.lms.auth.model.RegisterModel;

import java.util.List;

public interface AuthDao {
    
    public User register(RegisterModel newUser);
    public User logIn(LoginModel data);
    public User forgotPassword(String phoneNumber, String userType);
    public User updatePassword(User user, String newPassword);
    public List<Employee> getAllEmployeeList();
} 
