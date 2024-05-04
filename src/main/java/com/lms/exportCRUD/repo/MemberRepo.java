package com.lms.exportCRUD.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.connection.JDBCConnection;
import com.lms.exportCRUD.dal.MemberDao;
import com.lms.exportCRUD.entities.Member;

public class MemberRepo implements MemberDao {
    Connection connection = null;

    public MemberRepo() {
        connection = JDBCConnection.getJDBCConnection();
    }

    public MemberRepo(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> members = new ArrayList<Member>();
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM member";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberId(resultSet.getString("memberid"));
                member.setMemberName(resultSet.getString("membername"));
                member.setDob(resultSet.getString("dob"));
                member.setPhoneNumber(resultSet.getString("phonenumber"));
                member.setGender(resultSet.getString("gender"));
                members.add(member);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return members;
    }
}
