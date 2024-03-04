package com.lms.auth.model;

public class ModelForgot {

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ModelForgot(String phoneNumber, String userType) {
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public ModelForgot() {
    }

    private String phoneNumber;
    private String userType;
}
