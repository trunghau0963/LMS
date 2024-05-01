package com.lms.exportCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.exportCRUD.form.other.exportPanel;

public class ExportView extends JPanel {
    exportPanel exportPanel;
    private CardLayout cardLayout;

    public ExportView() {
        super();

        exportPanel = new exportPanel();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(exportPanel, "exportPanel");

        cardLayout.show(this, "exportPanel");

    }
}
