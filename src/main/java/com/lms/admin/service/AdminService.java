package com.lms.admin.service;

import java.util.List;

import com.lms.admin.dal.AdminDao;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.model.ModelLogin;
import com.lms.admin.model.ModelAddUser;

public class AdminService {
  private AdminDao adminDao;


  public AdminService(AdminDao adminDao) {
    this.adminDao = adminDao;
  }



  public User addUser(String userName, String phoneNumber, String pw, String userType, String gender, String dob, String fullName) {
    ModelAddUser newUser = new ModelAddUser(userName, fullName, phoneNumber, fullName, userType, gender, dob);
    return adminDao.addUser(newUser);
  }

}
