package com.lms.exportCRUD.service;

import java.util.ArrayList;

import com.lms.exportCRUD.dal.MemberDao;
import com.lms.exportCRUD.entities.Member;

public class MemberService {

    MemberDao dao;

    public MemberService(MemberDao memberDao) {
        this.dao = memberDao;
    }

    public ArrayList<Member> getAllMembers() {
        return dao.getAllMembers();
    }
}
