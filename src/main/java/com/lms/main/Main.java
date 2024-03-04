package com.lms.main;

import com.lms.auth.Login;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
    }
}
