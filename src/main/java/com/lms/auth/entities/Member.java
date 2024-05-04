package com.lms.auth.entities;

public class Member extends User {

    public Member() {
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


    public void setGender(String gender){
        this.gender = gender;
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


    public String getGender() {
        return gender;
    }

    
}
