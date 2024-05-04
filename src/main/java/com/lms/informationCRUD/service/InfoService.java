package com.lms.informationCRUD.service;

import com.lms.informationCRUD.model.ModelEditAccount;
import com.lms.auth.controller.BCrypt;
import com.lms.informationCRUD.dal.InfoDao;
import com.lms.informationCRUD.entities.Admin;
import com.lms.informationCRUD.entities.Employee;

public class InfoService {

    private InfoDao infoDao;

    public InfoService(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    public boolean editAccount(String phoneNumber, String pw, String fullName, String dob, String gender,
            String userType) {
        String hashed = BCrypt.hashpw(pw, BCrypt.gensalt(12));
        ModelEditAccount editUser = new ModelEditAccount(fullName, phoneNumber, dob, gender, hashed);
        if (userType.equals("Employee"))
            return infoDao.editEmployee(editUser);
        else if (userType.equals("Admin"))
            return infoDao.editAccount(editUser);
        return false;
    }

    public Admin getAdminById(String id) {
        return infoDao.getAdminById(id);
    }

    public Employee getEmployeeById(String id) {
        return infoDao.getEmployeeById(id);
    }

    public Employee getEmployeeByPhoneNumber(String phoneNumber) {
        return infoDao.getEmployeeByPhoneNumber(phoneNumber);
    }

    public Admin getAdminByPhoneNumber(String phoneNumber) {
        return infoDao.getAdminByPhoneNumber(phoneNumber);
    }
}
