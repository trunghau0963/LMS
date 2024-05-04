package com.lms.informationCRUD.entities;

public class Admin extends User {
    private String pwd;

    public Admin() {
        super();
    }

    public void setAdminId(String adminId) {
        this.Id = adminId;
    }

    public void setAdminName(String adminName) {
        this.Name = adminName;
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

    public String getAdminId() {
        return Id;
    }

    public String getAdminName() {
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

    @Override
    public String toString() {
        return "Admin [Id=" + Id + ", Name=" + Name + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", Gender="
                + gender + ", pwd=" + pwd + "]";
    }
}
