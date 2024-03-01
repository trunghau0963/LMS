package com.lms.main;

import com.lms.auth.Login;

public class Main {
    public static void main(String[] args) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);

    }   
}


