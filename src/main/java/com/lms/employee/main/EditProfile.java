package com.lms.employee.main;

import java.awt.CardLayout;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lms.employee.EditProfilePanel;

public class EditProfile extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public EditProfile() throws ParseException {
        setTitle("Publisher management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        EditProfilePanel editProfile = new EditProfilePanel("053e09ffa8061a20");
        mainPanel.add(editProfile, "editProfilePage");

        getContentPane().add(mainPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws ParseException {
        new EditProfile();
    }
}
