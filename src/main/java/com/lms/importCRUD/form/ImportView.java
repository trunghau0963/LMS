package com.lms.importCRUD.form;

import java.awt.CardLayout;

import javax.swing.*;

import com.lms.auth.entities.User;
import com.lms.importCRUD.form.other.ImportPanel;

public class ImportView extends JPanel {
    ImportPanel importPanel;
    private CardLayout cardLayout;
    private User user;

    public ImportView(User user) {
        super();
        this.user = user;

        importPanel = new ImportPanel(user);
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(importPanel, "importPanel");

        cardLayout.show(this, "importPanel");

    }

    public void setUserInformation(User user) {
        this.user = user;
        System.out.println("User: " + user.toString());
    }

}
