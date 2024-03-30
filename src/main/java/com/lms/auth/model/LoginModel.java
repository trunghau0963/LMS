package com.lms.auth.model;

public class LoginModel {

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LoginModel(String phoneNumber, String password, String userType) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userType = userType;
    }

    public LoginModel() {
    }

    private String phoneNumber;
    private String password;
    private String userType;
}
