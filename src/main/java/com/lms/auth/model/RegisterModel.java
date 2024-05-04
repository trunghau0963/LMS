package com.lms.auth.model;

public class RegisterModel {
    
    public RegisterModel(String name, String phoneNumber, String passwrord, String userType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passwrord = passwrord;
        this.userType = userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPasswrord(String passwrord) {
        this.passwrord = passwrord;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return passwrord;
    }

    public String getUserType() {
        return userType;
    }

    private String name;
    private String phoneNumber;
    private String passwrord;
    private String userType;
}
