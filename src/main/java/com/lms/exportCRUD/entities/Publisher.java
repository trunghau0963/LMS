package com.lms.exportCRUD.entities;

public class Publisher {
    private String id;
    private String name;
    private String address;
    private boolean isHide;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsHide() {
        return isHide;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHide(boolean isHide) {
        this.isHide = isHide;
    }
}
