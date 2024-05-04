package com.lms.informationCRUD.form;

import java.awt.CardLayout;
import java.text.ParseException;

import javax.swing.*;

import com.lms.auth.entities.User;
import com.lms.informationCRUD.dal.InfoDao;
import com.lms.informationCRUD.form.other.ViewInformation;
import com.lms.informationCRUD.repo.InfoRepo;
import com.lms.informationCRUD.service.InfoService;

public class InfoPage extends JPanel {
  private CardLayout cardLayout;
  User user;
  ViewInformation viewInformation;
  InfoDao infoDao;
  InfoService infoService;

  public InfoPage(User userParameter, String role) throws ParseException {
    super();
    this.user = userParameter;
    infoDao = new InfoRepo();
    infoService = new InfoService(infoDao);
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewInformation = new ViewInformation(userParameter, role, infoService);

    add(viewInformation, "viewInformation");

  }

}
