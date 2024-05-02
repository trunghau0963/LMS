package com.lms.accountCRUD.form;

import java.awt.CardLayout;

import javax.swing.*;

import com.lms.accountCRUD.form.other.ViewInformation;
import com.lms.accountCRUD.form.other.temp.EditAccount;

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
