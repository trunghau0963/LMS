package com.lms.employee.entities;

public class Employee {
    String empId, empName;
    String phoneNumber, pwd, gender;
    String dob;
    boolean isBlock;

    Employee(String empId, String empName, String dob, String phoneNumber, String pwd, String gender, boolean isBlock) {
        this.empId = empId;
        this.empName = empName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
        this.gender = gender;
        this.isBlock = isBlock;
    }

    Employee() {
        this.empId = "";
        this.empName = "";
        this.phoneNumber = "";
        this.pwd = "";
        this.gender = "";
        this.isBlock = false;
    }

    private void setId(String id) {
        this.empId = id;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.empName = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String getId() {
        return this.empId;
    }

    private String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName(){
        return this.empName;
    }

    public String getDob() {
        return this.dob;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getGender() {
        return this.gender;
    }
}
