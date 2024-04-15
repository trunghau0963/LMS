package com.lms.bookCRUD.form;

import javax.swing.*;

import com.lms.bookCRUD.form.other.AddBook;
import com.lms.bookCRUD.form.other.EditBook;
import com.lms.bookCRUD.form.other.ListBook;

import java.awt.*;

public class BookView extends JPanel {
  private static CardLayout cardLayout;
  AddBook addBook;
  static EditBook editBook;
  static ListBook listBook;

  public BookView() {
    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    addBook = new AddBook(cardLayout, this);
    editBook = new EditBook(cardLayout, this);
    listBook = new ListBook(cardLayout, this);

    add(addBook, "addBook");
    add(editBook, "editBook");
    add(listBook, "listBook");

    cardLayout.show(this, "listBook");

  }

  public static void loadEditBookPanel(String bookId) {
    editBook.setBookId(bookId);
    editBook.loadBook();
    cardLayout.show(editBook.getParent(), "editBook");
  }

  public static void reloadListBookTable() {
    listBook.reloadTable();
  }

}