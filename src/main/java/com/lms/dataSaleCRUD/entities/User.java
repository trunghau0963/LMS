package com.lms.dataSaleCRUD.entities;

public class User {
    protected String Id;
    protected String Name;
    protected String dob;
    protected String phoneNumber;
    protected String pwd;
    protected String gender;
    protected boolean isBlock;

    public User() {
        
    }

    public User(String Id, String Name, String dob, String phoneNumber, String pwd, String gender, boolean isBlock) {
        this.Id = Id;
        this.Name = Name;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
        this.gender = gender;
        this.isBlock = false;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
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

    public boolean isIsBlock() {
        return isBlock;
    }
    
    
}
