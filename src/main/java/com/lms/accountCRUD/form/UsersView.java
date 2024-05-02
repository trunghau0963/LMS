package com.lms.accountCRUD.form;

import javax.swing.*;

import com.lms.accountCRUD.dal.AdminDao;
import com.lms.accountCRUD.form.other.ViewListAccount;
import com.lms.accountCRUD.repo.AdminRepo;
import com.lms.accountCRUD.service.AdminService;

import java.awt.*;

public class UsersView extends JPanel {

  private AdminService adminService;
  private AdminDao adminDao;
  private CardLayout cardLayout;
  public static ViewListAccount viewListAccount;

  public UsersView() {

    super();

    adminDao = AdminRepo.getInstance();
    adminService = new AdminService(adminDao);
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewListAccount = new ViewListAccount(cardLayout, this, adminService);

    add(viewListAccount, "viewListAccount");
  }

}
