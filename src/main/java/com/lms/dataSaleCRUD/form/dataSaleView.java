package com.lms.dataSaleCRUD.form;

import java.awt.CardLayout;

import com.lms.dataSaleCRUD.form.other.viewDataSaleBookPanel;
import com.lms.dataSaleCRUD.form.other.viewDataSaleCategoryPanel;
import com.lms.dataSaleCRUD.form.other.viewDataSaleCustomerPanel;
import com.lms.dataSaleCRUD.form.other.viewDataSaleEmployeePanel;
import com.lms.dataSaleCRUD.form.other.viewDataSalePanel;

public class dataSaleView extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private viewDataSalePanel viewDataSalePanel;
    private viewDataSaleBookPanel viewDataSaleBookPanel;
    private viewDataSaleCustomerPanel viewDataSaleCustomerPanel;
    private viewDataSaleEmployeePanel viewDataSaleEmployeePanel;
    private viewDataSaleCategoryPanel viewDataSaleCategoryPanel;

    public dataSaleView() {
        super();
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        viewDataSalePanel = new viewDataSalePanel(cardLayout, this);
        viewDataSaleBookPanel = new viewDataSaleBookPanel(cardLayout, this);
        viewDataSaleCustomerPanel = new viewDataSaleCustomerPanel(cardLayout, this);
        viewDataSaleEmployeePanel = new viewDataSaleEmployeePanel(cardLayout, this);
        viewDataSaleCategoryPanel = new viewDataSaleCategoryPanel(cardLayout, this);

        add(viewDataSalePanel, "viewDataSalePanel");
        add(viewDataSaleBookPanel, "viewDataSaleBookPanel");
        add(viewDataSaleCustomerPanel, "viewDataSaleCustomerPanel");
        add(viewDataSaleEmployeePanel, "viewDataSaleEmployeePanel");
        add(viewDataSaleCategoryPanel, "viewDataSaleCategoryPanel");
    }
}
