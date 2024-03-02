package com.lms.auth.entities;

public class Employee extends User {

    public Employee() {
        super();
    }

    public void setEmpId(String empId) {
        this.Id = empId;
    }

    public void setEmpName(String empName) {
        this.Name = empName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public String getEmpId() {
        return Id;
    }

    public String getEmpName() {
        return Name;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public String getGender() {
        return gender;
    }

    public boolean getIsBlock() {
        return isBlock;
    }
}
