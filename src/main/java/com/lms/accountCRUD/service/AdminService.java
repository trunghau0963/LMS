package com.lms.accountCRUD.service;

import java.util.ArrayList;
import java.util.List;

import com.lms.accountCRUD.dal.AdminDao;
import com.lms.accountCRUD.model.ModelAddUser;
import com.lms.accountCRUD.model.ModelEditAccount;
import com.lms.accountCRUD.repo.AdminRepo;
import com.lms.auth.controller.BCrypt;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;

public class AdminService {
  private AdminDao adminDao;

  public static AdminService getInstance() {
    return new AdminService(AdminRepo.getInstance());
  }

  public AdminService(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  public User addUser(String phoneNumber, String pw, String userType, String gender, String dob, String fullName) {

    String hashed = BCrypt.hashpw(pw, BCrypt.gensalt(12));
    ModelAddUser newUser = new ModelAddUser(fullName, phoneNumber, hashed, userType, gender, dob);
    return adminDao.addUser(newUser);
  }

  public boolean editAccount(String phoneNumber, String pw, String fullName, String dob, String gender,
      String userType) {
    String hashed = BCrypt.hashpw(pw, BCrypt.gensalt(12));
    ModelEditAccount editUser = new ModelEditAccount(fullName, phoneNumber, dob, gender, hashed);
    if (userType.equals("Employee"))
      return adminDao.editEmployee(editUser);
    else if (userType.equals("Admin"))
      return adminDao.editAccount(editUser);
    return false;
  }

  public boolean editAccount(Admin admin) {
    String phoneNumber = admin.getPhoneNumber();
    String fullName = admin.getAdminName();
    String dob = admin.getDob();
    String gender = admin.getGender();
    String pw = admin.getPwd();
    String hashed = BCrypt.hashpw(pw, BCrypt.gensalt(12));
    ModelEditAccount editUser = new ModelEditAccount(fullName, phoneNumber, dob, gender, hashed);
    return adminDao.editAccount(editUser);
  }

  public boolean deleteAccount(String phoneNumber, String userType) {
    if (userType.equals("Employee"))
      return adminDao.deleteEmployee(phoneNumber);
    else if (userType.equals("Admin"))
      return adminDao.deleteAccount(phoneNumber);
    return false;
  }

  public List<Employee> getEmployees() {
    return adminDao.getEmployees();
  }

  public List<Admin> getAdmins() {
    return adminDao.getAdmins();
  }

  public List<Admin> SearchAllAdmin(String search) {
    List<Admin> result = new ArrayList<Admin>();
    List<Admin> all = adminDao.getAdmins();
    for (Admin admin : all) {
      if (admin.getAdminName().toLowerCase().contains(search.toLowerCase())
          || admin.getPhoneNumber().toLowerCase().contains(search.toLowerCase())) {
        result.add(admin);
      }
    }
    return result;
  }

  public List<Admin> SearchByNameAdmin(String search) {
    List<Admin> result = new ArrayList<Admin>();
    List<Admin> all = adminDao.getAdmins();
    for (Admin admin : all) {
      if (admin.getAdminName().toLowerCase().contains(search.toLowerCase())) {
        result.add(admin);
      }
    }
    return result;
  }

  public List<Admin> SearchByPhoneAdmin(String search) {
    List<Admin> result = new ArrayList<Admin>();
    List<Admin> all = adminDao.getAdmins();
    for (Admin admin : all) {
      if (admin.getPhoneNumber().toLowerCase().contains(search.toLowerCase())) {
        result.add(admin);
      }
    }
    return result;
  }

  public List<Employee> SearchAllEmployee(String search) {
    List<Employee> result = new ArrayList<Employee>();
    List<Employee> all = adminDao.getEmployees();
    for (Employee emp : all) {
      if (emp.getEmpName().toLowerCase().contains(search.toLowerCase())
          || emp.getPhoneNumber().toLowerCase().contains(search.toLowerCase())) {
        result.add(emp);
      }
    }
    return result;
  }

  public List<Employee> SearchByNameEmployee(String search) {
    List<Employee> result = new ArrayList<Employee>();
    List<Employee> all = adminDao.getEmployees();
    for (Employee emp : all) {
      if (emp.getEmpName().toLowerCase().contains(search.toLowerCase())) {
        result.add(emp);
      }
    }
    return result;
  }

  public List<Employee> SearchByPhoneEmployee(String search) {
    List<Employee> result = new ArrayList<Employee>();
    List<Employee> all = adminDao.getEmployees();
    for (Employee emp : all) {
      if (emp.getPhoneNumber().toLowerCase().contains(search.toLowerCase())) {
        result.add(emp);
      }
    }
    return result;
  }

  public Employee getEmployeeByPhoneNumber(String phoneNumber) {
    return adminDao.getEmployeeByPhoneNumber(phoneNumber);
  }

  public Employee getEmployeeByName(String name) {
    return adminDao.getEmployeeByName(name);
  }

  public Admin getAdminByPhoneNumber(String phoneNumber) {
    return adminDao.getAdminByPhoneNumber(phoneNumber);
  }

  public Admin getAdminByName(String name) {
    return adminDao.getAdminByName(name);
  }

  public Admin getAdminById(String id) {
    System.out.println("AdminService.getAdminById: " + id);
    Admin result = adminDao.getAdminById(id);
    if (result == null) {
      return null;
    }
    System.out.println(result.toString());
    return result;
  }

  public Employee getEmployeeById(String id) {
    return adminDao.getEmployeeById(id);
  }

  public boolean toggleBlockUser(String phoneNumber, boolean isBlocked) {
    return adminDao.toggleBlock(phoneNumber, isBlocked);
  }

}
