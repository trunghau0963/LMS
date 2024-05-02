package com.lms.accountCRUD.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.accountCRUD.model.ModelAddUser;
import com.lms.accountCRUD.model.ModelEditAccount;
import com.lms.auth.entities.Admin;

import java.util.List;

public interface AdminDao {

  public User addUser(ModelAddUser newUser);

  public boolean editAccount(ModelEditAccount editUser);

  public boolean editEmployee(ModelEditAccount editUser);

  public boolean deleteAccount(String phoneNumber);

  public boolean deleteEmployee(String phoneNumber);

  public List<Employee> getEmployees();

  public List<Admin> getAdmins();

  public Admin getAdminById(String id);

  public Employee getEmployeeById(String id);

  public Employee getEmployeeByPhoneNumber(String phoneNumber);

  public Employee getEmployeeByName(String name);

  public Admin getAdminByPhoneNumber(String phoneNumber);

  public Admin getAdminByName(String name);

  public boolean toggleBlock(String phoneNumber, boolean isBlocked);

}
