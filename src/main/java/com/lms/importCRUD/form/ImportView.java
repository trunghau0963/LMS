package com.lms.importCRUD.form;

import java.awt.CardLayout;

import javax.swing.*;

import com.lms.auth.entities.User;
import com.lms.importCRUD.form.other.ImportPanel;

public class ImportView extends JPanel {
    ImportPanel importPanel;
    private CardLayout cardLayout;

    public ImportView(User user) {
        super();

        importPanel = new ImportPanel();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(importPanel, "importPanel");

        cardLayout.show(this, "importPanel");

    }
}
