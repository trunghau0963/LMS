package com.lms.admin.main;

import javax.swing.*;

import com.lms.admin.AddUser;
import com.lms.admin.ViewListAccount;

import java.awt.*;

public class UsersPage extends JPanel {
  private CardLayout cardLayout;
  ViewListAccount viewListAccount;
  public AddUser addUser;

  public UsersPage() {

    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewListAccount = new ViewListAccount(cardLayout, this);
    addUser = new AddUser(cardLayout, this);

    add(viewListAccount, "viewListAccount");
    add(addUser, "addUser");
  }

  
}
