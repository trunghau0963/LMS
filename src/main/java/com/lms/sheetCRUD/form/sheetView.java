package com.lms.sheetCRUD.form;

import java.awt.CardLayout;

import com.lms.sheetCRUD.form.other.sheetList;

public class sheetView extends javax.swing.JPanel {
    private CardLayout cardLayout;
    public static sheetList sheetList;
    public sheetView() {

        super();

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        sheetList = new sheetList();
        add(sheetList, "sheetList");
        cardLayout.show(this, "sheetList");
    }
}
