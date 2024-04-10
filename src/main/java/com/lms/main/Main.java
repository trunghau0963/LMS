package com.lms.main;

import java.awt.Font;

import javax.swing.UIManager;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.FlatDarkLaf;
import com.lms.auth.repo.AuthRepo;
import com.lms.auth.service.AuthService;
import com.lms.dashboard.application.Application;

public class Main {
    public static void main(String[] args) {

        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("", 10);
        UIManager.put("Button.arc", 10);

        AuthRepo authRepo = new AuthRepo();
        AuthService authService = new AuthService(authRepo);
        FlatSVGIcon icon = new FlatSVGIcon("svg/logo.svg");
        
        // Login login = new Login(authService);
        // login.setVisible(true);
        // login.pack();
        // login.setLocationRelativeTo(null);
        
        FlatDarkLaf.setup();
        
        Application application = new Application(authService);
        application.setSize(960, 580);
        application.setVisible(true);
        application.setIconImage(icon.getImage());
    }
}
