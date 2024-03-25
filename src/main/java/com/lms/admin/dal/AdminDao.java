package com.lms.admin.dal;

import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;

import com.lms.admin.model.ModelAddUser;
import java.util.List;

public interface AdminDao {

  public User addUser(ModelAddUser newUser);

}
