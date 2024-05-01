package com.lms.accountCRUD.model;

public class ModelEditAccount {
  private String userName;
  private String fullName;
  private String phoneNumber;
  private String dob;
  private String gender;
  private String pwd;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

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

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public ModelEditAccount(String fullName, String phoneNumber, String dob, String gender, String pwd) {

    this.fullName = fullName;
    this.phoneNumber = phoneNumber;
    this.dob = dob;
    this.gender = gender;
    this.pwd = pwd;
  }



}
