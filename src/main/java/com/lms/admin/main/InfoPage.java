package com.lms.admin.main;

import java.awt.CardLayout;

import javax.swing.*;

import com.lms.admin.EditAccount;
import com.lms.admin.ViewInformation;

public class InfoPage extends JPanel {
  private CardLayout cardLayout;
  EditAccount editAccount;
  ViewInformation viewInformation;

  public InfoPage() {
    super();
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewInformation = new ViewInformation(cardLayout, this);
    editAccount = new EditAccount(cardLayout, this);
    
    add(viewInformation, "viewInformation");
    add(editAccount, "editAccount");

  }

}
