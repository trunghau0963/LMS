package com.lms.authorCRUD.form;

import java.awt.CardLayout;
import java.text.ParseException;
import javax.swing.JPanel;

import com.lms.authorCRUD.form.other.EditProfilePanel;

public class EditProfile extends JPanel {
    private CardLayout cardLayout;

    public EditProfile(String id) throws ParseException {
        // Tạo CardLayout
        super();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        EditProfilePanel editProfile = new EditProfilePanel(id);
        this.add(editProfile, "editProfilePage");
    }
}
