package com.lms.UserCRUD.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.UserCRUD.model.ModelAddUser;
import com.lms.UserCRUD.model.ModelEditAccount;
import com.lms.auth.entities.Admin;

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
