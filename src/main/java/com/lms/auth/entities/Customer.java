package com.lms.auth.entities;

public class Customer extends User {
    public boolean isMember;

    public Customer() {
        super();
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
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

    public boolean getIsMember() {
        return isMember;
    }
    
}
