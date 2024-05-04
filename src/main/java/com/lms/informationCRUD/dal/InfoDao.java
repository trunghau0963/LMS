package com.lms.informationCRUD.dal;

import com.lms.informationCRUD.model.ModelEditAccount;
import com.lms.informationCRUD.entities.Admin;
import com.lms.informationCRUD.entities.Employee;

public interface InfoDao {
    public boolean editAccount(ModelEditAccount editUser);

    public boolean editEmployee(ModelEditAccount editUser);

    public Admin getAdminById(String id);

    public Employee getEmployeeById(String id);

    public Employee getEmployeeByPhoneNumber(String phoneNumber);

    public Admin getAdminByPhoneNumber(String phoneNumber);
    // public User updatePassword(User user, String newPassword);
}
