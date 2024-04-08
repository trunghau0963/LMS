package com.lms.admin.model;

public class ModelAddUser {

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public ModelAddUser(String fullName, String phoneNumber, String password, String userType, String gender,
      String dob) {

    this.fullName = fullName;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.userType = userType;
    this.gender = gender;
    this.dob = dob;
  }

  private String fullName;
  private String phoneNumber;
  private String password;
  private String userType;
  private String gender;
  private String dob;

}
