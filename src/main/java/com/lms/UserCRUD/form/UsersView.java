package com.lms.userCRUD.form;

import javax.swing.*;

import com.lms.userCRUD.dal.AdminDao;
import com.lms.userCRUD.form.other.ViewListAccount;
import com.lms.userCRUD.repo.AdminRepo;
import com.lms.userCRUD.service.AdminService;

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
