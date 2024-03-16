package com.lms.auth.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.ModelLogin;
import com.lms.auth.model.ModelRegister;
import java.util.List;

public interface AuthDao {
    
    public User register(ModelRegister newUser);
    public User logIn(ModelLogin data);
    public User forgotPassword(String phoneNumber, String userType);
    public List<Employee> getAllEmployeeList();
    public User updatePassword(User user, String newPassword);
} 
