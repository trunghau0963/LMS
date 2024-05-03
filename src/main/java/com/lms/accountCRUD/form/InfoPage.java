package com.lms.accountCRUD.form;

import java.awt.CardLayout;

import javax.swing.*;

import com.lms.accountCRUD.form.other.ViewInformation;

public class InfoPage extends JPanel {
  private CardLayout cardLayout;
  ViewInformation viewInformation;

  public InfoPage() {
    super();
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewInformation = new ViewInformation(cardLayout, this);
    
    add(viewInformation, "viewInformation");

  }

}
