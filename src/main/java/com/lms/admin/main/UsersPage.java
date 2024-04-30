package com.lms.admin.main;

import javax.swing.*;

import com.lms.admin.AddUser;
import com.lms.admin.ViewListAccount;

import java.awt.*;

public class UsersPage extends JPanel{
  private CardLayout cardLayout;
  ViewListAccount viewListAccount;
  AddUser addUser;

  public UsersPage(){
    
    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewListAccount = new ViewListAccount(cardLayout, this);
    addUser = new AddUser();

    add(viewListAccount, "viewListAccount");
    add(addUser, "addUser");
  }

}
