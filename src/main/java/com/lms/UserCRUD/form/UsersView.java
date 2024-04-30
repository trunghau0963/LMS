package com.lms.UserCRUD.form;

import javax.swing.*;

import com.lms.UserCRUD.dal.AdminDao;
import com.lms.UserCRUD.form.other.ViewListAccount;
import com.lms.UserCRUD.repo.AdminRepo;
import com.lms.UserCRUD.service.AdminService;

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
