package com.lms.main;

import com.lms.auth.Login;
import com.lms.admin.AddUser;
import com.lms.admin.ViewListAccount;

public class Main {
    public static void main(String[] args) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);

        AddUser a = new AddUser();
        a.setVisible(true);

        ViewListAccount b = new ViewListAccount();
        b.setVisible(true);

        
    }   
}


