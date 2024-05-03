package com.lms.exportCRUD.entities;

public class Author {
    private String id;
    private String name;
    private String gender;
    private boolean isHide;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public boolean getIsHide() {
        return isHide;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHide(boolean isHide) {
        this.isHide = isHide;
    }

    public void setName(String name) {
        this.name = name;
    }
}
