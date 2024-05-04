package com.lms.exportCRUD.dal;
import java.util.ArrayList;

import com.lms.exportCRUD.entities.Member;

public interface MemberDao {
    
    public ArrayList<Member> getAllMembers();
}
