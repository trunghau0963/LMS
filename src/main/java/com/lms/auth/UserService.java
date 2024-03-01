package com.lms.auth;

import java.util.List;

public class UserService {
        private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User register(String userName, String phoneNumber, String pw){
        User newUser = new User();
        newUser.setName(userName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPwd(pw);
        return userDao.register(newUser);
    }

    public User registerUser(User data){
        return userDao.register(data);
    }
    
    public User logIn(String phoneNumber, String pwd, String userType) {
        ModelLogin data = new ModelLogin();
        data.setPhoneNumber(phoneNumber);
        data.setPassword(pwd);
        data.setUserType(userType);
        return userDao.logIn(data);
    }

    public List<User> getAllEmployees() {
        return userDao.getAllEmployeeList();
    }
}
