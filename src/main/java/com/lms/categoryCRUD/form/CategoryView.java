package com.lms.categoryCRUD.form;

import javax.swing.*;

import com.lms.categoryCRUD.dal.CategoryDao;
import com.lms.categoryCRUD.form.other.ListBookCategory;
import com.lms.categoryCRUD.repo.CategoryRepo;
import com.lms.categoryCRUD.service.CategoryService;

import java.awt.*;

public class CategoryView extends JPanel {
  ListBookCategory listBookCategory;
  private CategoryDao categoryDao;
  private CategoryService categoryService;
  private CardLayout cardLayout;

  public CategoryView() {
    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    categoryDao = CategoryRepo.getInstance();
    categoryService = new CategoryService(categoryDao);
    listBookCategory = new ListBookCategory(categoryService);

    add(listBookCategory, "listBookCategory");

    cardLayout.show(this, "listBookCategory");

  }
}