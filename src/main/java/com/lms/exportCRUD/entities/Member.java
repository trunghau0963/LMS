package com.lms.exportCRUD.entities;

public class Member {
    String memberid;
    String membername;
    String dob;
    String phonenumber;
    String gender;

    public Member() {
    }

    public Member(String memberid, String membername, String dob, String phonenumber, String gender) {
        this.memberid = memberid;
        this.membername = membername;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public void setMemberId(String memberid) {
        this.memberid = memberid;
    }

    public void setMemberName(String membername) {
        this.membername = membername;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMemberId() {
        return memberid;
    }

    public String getMemberName() {
        return membername;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberid='" + memberid + '\'' +
                ", membername='" + membername + '\'' +
                ", dob='" + dob + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", gender='" + gender + '\'';
    }

}
