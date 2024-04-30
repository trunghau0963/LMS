package com.lms.admin.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.entities.Admin;

import com.lms.admin.model.ModelEditAccount;
import com.lms.admin.model.ModelAddUser;
import java.util.List;

public interface AdminDao {

  public User addUser(ModelAddUser newUser);

  public boolean editAccount(ModelEditAccount editUser);
  
  public List<Employee> getEmployees();

  public List<Admin> getAdmins();

  public Employee getEmployeeByPhoneNumber(String phoneNumber);

  public Employee getEmployeeByName(String name);

  public Admin getAdminByPhoneNumber(String phoneNumber);

  public Admin getAdminByName(String name);

  public boolean toggleBlock(String phoneNumber, boolean isBlocked);

}
