package com.lms.employee.entities;

public class Author {
    String authorId, authorName, gender;
    boolean isHide;

    public Author(String id, String name, String gender, boolean isHide) {
        this.authorId = id;
        this.authorName = name;
        this.gender = gender;
        this.isHide = isHide;
    }

    public Author(){
        this.authorId = "";
        this.authorName = "";
        this.isHide = false;
    }

    public void setAuthorName(String name) {
        this.authorName = name; 
    }

    public void setAuthorId(String id) {
        this.authorId = id; 
    }

    public void setAuthorGender(String gender) {
        this.gender = gender; 
    }

    public void setVisible(boolean visible) {
        this.isHide = visible; 
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorGender() {
        return gender;
    }

    public boolean isHide() {
        return isHide;
    }

    @Override
    public String toString(){
        return  authorId + " " + authorName +  " " + gender + " " + isHide;
    }
}
