package com.lms.categoryCRUD.main;

import javax.swing.*;

import com.lms.categoryCRUD.ListBookCategory;

import java.awt.*;

public class CategoryView extends JPanel {
  ListBookCategory listBookCategory;
  private CardLayout cardLayout;

  public CategoryView() {
    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    listBookCategory = new ListBookCategory();

    add(listBookCategory, "listBookCategory");

    cardLayout.show(this, "listBookCategory");

  }
}