package com.lms.category.main;

import javax.swing.*;

import com.lms.category.ListBookCategory;

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