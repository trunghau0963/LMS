package com.lms.admin.service;

import java.util.List;

import com.lms.admin.dal.AdminDao;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.admin.model.ModelEditAccount;
import com.lms.admin.model.ModelAddUser;

public class AdminService {
  private AdminDao adminDao;

  public AdminService(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  public User addUser(String phoneNumber, String pw, String userType, String gender, String dob, String fullName) {

    ModelAddUser newUser = new ModelAddUser(fullName, phoneNumber, pw, userType, gender, dob);
    return adminDao.addUser(newUser);
  }

  public boolean editAccount(String phoneNumber, String pw, String fullName, String dob, String gender) {
    ModelEditAccount editUser = new ModelEditAccount(fullName, phoneNumber, dob, gender, pw);
    return adminDao.editAccount(editUser);
  }

  public List<Employee> getEmployees() {
    return adminDao.getEmployees();
  }

  public List<Admin> getAdmins() {
    return adminDao.getAdmins();
  }

  public Employee getEmployeeByPhoneNumber(String phoneNumber) {
    return adminDao.getEmployeeByPhoneNumber(phoneNumber);
  }

  public Employee getEmployeeByName(String name) {
    return adminDao.getEmployeeByName(name);
  }

}
