package com.lms.exportCRUD.model;

import com.lms.exportCRUD.entities.Member;

public class MemberModel {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void loadFromEntity(Member member) {
        id = member.getMemberId();
        name = member.getMemberName();
    }

    @Override
    public String toString() {
        return name;
    }
}
