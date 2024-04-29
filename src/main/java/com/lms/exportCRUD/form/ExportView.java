package com.lms.exportCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.exportCRUD.form.other.ExportPanel;

public class ExportView extends JPanel {
    ExportPanel exportPanel;
    private CardLayout cardLayout;

    public ExportView() {
        super();

        exportPanel = new ExportPanel();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(exportPanel, "exportPanel");

        cardLayout.show(this, "exportPanel");

    }
}
