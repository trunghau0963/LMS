package com.lms.userCRUD.form;

import javax.swing.*;

import com.lms.userCRUD.form.other.AddUser;
import com.lms.userCRUD.form.other.ViewListAccount;

import java.awt.*;

public class UsersPage extends JPanel {
  private CardLayout cardLayout;
  public static ViewListAccount viewListAccount;
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
